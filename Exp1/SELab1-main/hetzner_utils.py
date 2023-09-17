from hcloud import Client
from hcloud.images.domain import Image
import main
import time
import uuid
from check_utils import check_ip
from cloudflare_utils import change_dns

hclient = Client(token=main.CONFIG['hetzner_api_token'])


def change_ip():
    server = hclient.servers.get_all()[0]
    snapshot = hclient.images.get_all(type="snapshot")[0]
    server_type = hclient.server_types.get_by_id(server.server_type.id)
    ssh_keys = hclient.ssh_keys.get_all()

    trash_servers = []
    while True:
        new_server_resp = hclient.servers.create(
            name="rlty" + uuid.uuid4().hex[:8],
            server_type=server_type,
            image=Image(id=snapshot.id),
            ssh_keys=ssh_keys,
            datacenter=server.datacenter,
            start_after_create=True,
        )
        new_server = new_server_resp.server
        new_server_resp.action.wait_until_finished(max_retries=1e10)
        time.sleep(15)
        new_ip = new_server.public_net.ipv4.ip
        try:
            check_ip(new_ip, main.CONFIG['user'], main.CONFIG['timeout'])
            break
        except Exception as e:
            print('retry')
            trash_servers.append(new_server)
            continue
    for server in trash_servers:
        server.delete()
    change_dns(new_server.public_net.ipv4.ip)
    time.sleep(60 * 5)
    server.delete()
