package com.git.wuqf.registry;

import com.git.wuqf.constant.ZKConstant;
import io.netty.util.internal.ThreadLocalRandom;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.CountDownLatch;

/**
 * Created by sdzn-dsj on 2016/12/13.
 */
public class ServiceDiscovery {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceDiscovery.class);
    private String registryAddress;
    private ZookeeperUtil zookeeperUtil;

    public ServiceDiscovery(String registryAddress) {
        this.registryAddress = registryAddress;
        zookeeperUtil=new ZookeeperUtil(registryAddress);
    }

    public String discover() {
        byte[] data=zookeeperUtil.readNode(ZKConstant.ZK_DATA_PATH);
        String url=new String(data);
        return url;
    }
}
