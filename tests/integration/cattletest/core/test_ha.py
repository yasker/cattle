from common_fixtures import *  # NOQA
import logging


def _process_names(processes):
    return set([x.processName for x in processes])


def test_container_ha_default(client, super_client, user_sim_context):
    c = client.create_container(imageUuid=user_sim_context['imageUuid'],
                                requestedHostId=user_sim_context['host'].id,
                                name='simForgetImmediately')
    c = client.wait_success(c)

    def do_ping():
        ping = one(super_client.list_task, name='agent.ping')
        ping.execute()

    def callback():
        processes = process_instances(super_client, c, type='instance')
        if 'instance.stop' not in _process_names(processes):
            do_ping()
            return None
        return processes

    processes = wait_for(callback)

    c = client.wait_success(c)

    if c.state != 'stopped':
        logging.warn('test_container_ha_default debugging')
        for p in processes:
            logging.warn('ProcessInstance: %s' % p)
            for pe in process_executions(super_client, p.id):
                logging.warn('ProcessExecution: %s' % pe)

    assert c.state == 'stopped'
    assert _process_names(processes) == set(['instance.create',
                                             'instance.stop'])


def test_container_ha_stop(super_client, sim_context):
    c = super_client.create_container(imageUuid=sim_context['imageUuid'],
                                      requestedHostId=sim_context['host'].id,
                                      instanceTriggeredStop='stop',
                                      systemContainer='NetworkAgent',
                                      data={'simForgetImmediately': True})
    c = super_client.wait_success(c)

    def do_ping():
        ping = one(super_client.list_task, name='agent.ping')
        ping.execute()

    def callback():
        processes = process_instances(super_client, c, type='instance')
        if 'instance.stop' not in _process_names(processes):
            do_ping()
            return None
        return processes

    processes = wait_for(callback)

    c = super_client.wait_success(c)
    assert c.state == 'stopped'

    assert _process_names(processes) == set(['instance.create',
                                             'instance.restart',
                                             'instance.stop'])


def test_container_ha_restart(super_client, sim_context):
    c = super_client.create_container(imageUuid=sim_context['imageUuid'],
                                      requestedHostId=sim_context['host'].id,
                                      instanceTriggeredStop='restart',
                                      systemContainer='NetworkAgent',
                                      data={'simForgetImmediately': True})
    c = super_client.wait_success(c)

    def do_ping():
        ping = one(super_client.list_task, name='agent.ping')
        ping.execute()

    def callback():
        processes = process_instances(super_client, c, type='instance')
        if 'instance.start' not in _process_names(processes):
            do_ping()
            return None
        return processes

    processes = wait_for(callback)

    c = super_client.wait_success(c)
    assert c.state == 'running'

    assert _process_names(processes) == set(['instance.create',
                                             'instance.restart',
                                             'instance.stop',
                                             'instance.start'])


def test_container_ha_remove(super_client, sim_context):
    c = super_client.create_container(imageUuid=sim_context['imageUuid'],
                                      requestedHostId=sim_context['host'].id,
                                      instanceTriggeredStop='remove',
                                      systemContainer='NetworkAgent',
                                      data={'simForgetImmediately': True})
    c = super_client.wait_success(c)

    def do_ping():
        ping = one(super_client.list_task, name='agent.ping')
        ping.execute()

    def callback():
        processes = process_instances(super_client, c, type='instance')
        if 'instance.remove' not in _process_names(processes):
            do_ping()
            return None
        return processes

    processes = wait_for(callback)

    c = super_client.wait_success(c)
    assert c.state == 'removed'

    assert _process_names(processes) == set(['instance.create',
                                             'instance.restart',
                                             'instance.stop',
                                             'instance.remove'])


def process_executions(cli, id=None):
    return cli.list_process_execution(processInstanceId=id)
