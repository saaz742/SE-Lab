import time
import hetzner_utils
import check_utils

CONFIG = {
    'domain': 'example.com',
    'user': 'root',
    'timeout': 5,
    'interval': 60 * 3,
    'private_key_path': '/home/user/.ssh/id_rsa',
    'hetzner_api_token': '123',
    'cf_token': 'Bearer 80',
    'cf_zone_id': '80',
    'cf_domain_id': '80',
}


def maintain():
    while True:
        try:
            check_utils.check_ip(CONFIG['domain'], CONFIG['user'], CONFIG['timeout'])
        except Exception as e:
            hetzner_utils.change_ip()
        time.sleep(CONFIG['interval'])


maintain()
