package ua.com.lviv.tc.service.impl;

import org.apache.log4j.Logger;
import ua.com.lviv.tc.entity.Bucket;
import ua.com.lviv.tc.repositories.BucketRepository;
import ua.com.lviv.tc.repositories.impl.BucketRepositoryImpl;
import ua.com.lviv.tc.service.BucketService;

import java.util.List;
import java.util.Optional;

public class BucketServiceImpl implements BucketService {

    BucketRepository bucketRepository;
    Logger log = Logger.getLogger(BucketServiceImpl.class);

    public BucketServiceImpl() {
        this.bucketRepository = BucketRepositoryImpl.getInstance();
    }

    @Override
    public void save(Bucket bucket) {
        log.debug("saving bucket " + bucket);
        bucketRepository.save(bucket);
    }

    @Override
    public void update(Bucket bucket) {
        log.debug("updating bucket " + bucket);
        bucketRepository.update(bucket);
    }

    @Override
    public List<Bucket> findAll() {
        log.debug("find all buckets");
        return bucketRepository.findAll();
    }

    @Override
    public Optional<Bucket> findById(Integer id) {
        log.debug("finding bucket by id " + id);
        return bucketRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        log.debug("deleting bucket by id " + id);
        bucketRepository.deleteById(id);
    }
}
