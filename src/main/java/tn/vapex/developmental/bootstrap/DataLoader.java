package tn.vapex.developmental.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import tn.vapex.core.properties.VapexProperties;
import tn.vapex.developmental.Developmental;

import javax.annotation.PostConstruct;


@ConditionalOnProperty(name = "vapex.data-loader.enabled", havingValue = "true")
@Developmental
@Slf4j
public abstract class DataLoader {
    @Autowired
    protected VapexProperties vapexProperties;

    protected abstract void load();

    protected abstract void purge();

    protected abstract void log();


    @PostConstruct
    private void run() {
        log.warn("Purging before loading...");
        this.purge();
        this.log();
        this.load();
    }

}
