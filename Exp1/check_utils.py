import paramiko
import main


def check_ip(domain, user, timeout):
    k = paramiko.RSAKey.from_private_key_file(main.CONFIG['private_key_path'])
    c = paramiko.SSHClient()
    c.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    for i in range(3):
        try:
            c.connect(hostname=domain, username=user, pkey=k, timeout=timeout)
        except:
            print('retrying')
            continue
        break
    else:
        c.close()
        raise Exception("could not connect to server")
    command = "curl -s -o /dev/null -I -w \"%{http_code}\"  https://www.spotify.com"
    for i in range(3):
        try:
            stdin, stdout, stderr = c.exec_command(command, timeout=timeout)
        except:
            print('retrying')
            continue
        break
    else:
        c.close()
        raise Exception("could not execute command")
    status_code = int(stdout.read().decode())
    c.close()
    if status_code == 403:
        raise Exception("proxy is detected")
