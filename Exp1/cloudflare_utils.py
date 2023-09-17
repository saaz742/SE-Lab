import requests
import main


def change_dns(new_ip):
    headers = {
        'Content-Type': 'application/json',
        'Authorization': main.CONFIG['cf_token'],
    }

    json_data = {
        'content': new_ip,
        'name': main.CONFIG['domain'],
        'type': 'A',
    }

    for i in range(3):
        try:
            response = requests.patch(
                f"https://api.cloudflare.com/client/v4/zones/{main.CONFIG['cf_zone_id']}/dns_records/{main.CONFIG['cf_domain_id']}",
                headers=headers,
                json=json_data,
                timeout=main.CONFIG['timeout'] * 4
            )
            response.raise_for_status()
            if response.status_code == 200:
                break
            else:
                continue
        except Exception as e:
            print('nooooo')
    else:
        raise Exception('nooooo')
    print('yessss')
