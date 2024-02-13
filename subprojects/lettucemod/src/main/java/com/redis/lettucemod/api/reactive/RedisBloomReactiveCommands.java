package com.redis.lettucemod.api.reactive;

import com.redis.lettucemod.bloom.*;
import com.redis.lettucemod.cms.CmsInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RedisBloomReactiveCommands<K,V>{
    Mono<Boolean> bfAdd(K key, V item);
    Mono<Long> bfCard(K key);
    Mono<Boolean> bfExists(K key, V item);
    Mono<BfInfo> bfInfo(K key);
    Mono<Long> bfInfo(K key, BfInfoType infoType);
    Flux<Boolean> bfInsert(K key, V... items);
    Flux<Boolean> bfInsert(K key, BfInsertOptions options, V... items);
    Flux<Boolean> bfMAdd(K key, V... items);
    Flux<Boolean> bfMExists(K key, V... items);
    Mono<String> bfReserve(K key, BfConfig config);
    Mono<Boolean> cfAdd(K key, V item);
    Mono<Boolean> cfAddNx(K key, V item);
    Mono<Long> cfCount(K key, V item);
    Mono<Boolean> cfDel(K key, V item);
    Mono<Boolean> cfExists(K key, V item);
    Mono<CfInfo> cfInfo(K key);
    Flux<Long> cfInsert(K key, V... items);
    Flux<Long> cfInsert(K key, CfInsertOptions options, V... items);
    Flux<Long> cfInsertNx(K key, V... items);
    Flux<Long> cfInsertNx(K key, CfInsertOptions options, V... items);
    Flux<Boolean> cfMExists(K key, V... items);
    Mono<String> cfReserve(K key, Long capacity);
    Mono<String> cfReserve(K key, CfReserveOptions options);
    Mono<Long> cmsIncrBy(K key, V item, long increment);
    Flux<Long> cmsIncrBy(K key, Map<V,Long> increments);
    Mono<String> cmsInitByProb(K key, double error, double probability);
    Mono<String> cmsInitByDim(K key, long width, long depth);
    Flux<Long> cmsQuery(K key, V... items);
    Mono<String> cmsMerge(K destKey, K... keys);
    Mono<String> cmsMerge(K destKey, Map<K,Long> keyWeightMap);
    Mono<CmsInfo> cmsInfo(K key);
    Flux<Optional<V>> topKAdd(K key, V... items);
    Flux<Optional<V>> topKIncrBy(K key, Map<V, Long> increments);
    Mono<TopKInfo> topKInfo(K key);
    Flux<String> topKList(K key);
    Mono<Map<String, Long>> topKListWithScores(K key);
    Flux<Boolean> topKQuery(K key, V... items);
    Mono<String> topKReserve(K key, long k);
    Mono<String> topKReserve(K key, long k, long width, long depth, double decay);
    Mono<String> tDigestAdd(K key, double... values);
    Flux<Double> tDigestByRank(K key, long... ranks);
    Flux<Double> tDigestByRevRank(K key, long... revRanks);
    Flux<Double> tDigestCdf(K key, double... values);
    Mono<String> tDigestCreate(K key);
    Mono<String> tDigestCreate(K key, long compression);
    Mono<TDigestInfo> tDigestInfo(K key);
    Mono<Double> tDigestMax(K key);
    Mono<String> tDigestMerge(K destinationKey, K... sourceKeys);
    Mono<String> tDigestMerge(K destinationKey, TDigestMergeOptions options, K... sourceKeys);
    Mono<Double> tDigestMin(K key);
    Flux<Double> tDigestQuantile(K key, double... quantiles);
    Flux<Long> tDigestRank(K key, double... values);
    Mono<String> tDigestReset(K key);
    Flux<Long>  tDigestRevRank(K key, double... values);
    Mono<Double> tDigestTrimmedMean(K key, double lowCutQuantile, double highCutQuantile);
}
