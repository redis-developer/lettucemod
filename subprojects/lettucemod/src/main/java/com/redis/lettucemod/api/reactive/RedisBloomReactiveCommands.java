package com.redis.lettucemod.api.reactive;

import com.redis.lettucemod.bloom.BloomFilterInfo;
import com.redis.lettucemod.bloom.BloomFilterInfoType;
import com.redis.lettucemod.bloom.BloomFilterInsertOptions;
import com.redis.lettucemod.bloom.BloomFilterReserveOptions;
import com.redis.lettucemod.bloom.CmsInfo;
import com.redis.lettucemod.bloom.CuckooFilter;
import com.redis.lettucemod.bloom.CuckooFilterInsertOptions;
import com.redis.lettucemod.bloom.CuckooFilterReserveOptions;
import com.redis.lettucemod.bloom.LongScoredValue;
import com.redis.lettucemod.bloom.TDigestInfo;
import com.redis.lettucemod.bloom.TDigestMergeOptions;
import com.redis.lettucemod.bloom.TopKInfo;

import io.lettuce.core.KeyValue;
import io.lettuce.core.Value;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SuppressWarnings("unchecked")
public interface RedisBloomReactiveCommands<K, V> {

	Mono<Boolean> bfAdd(K key, V item);

	Mono<Long> bfCard(K key);

	Mono<Boolean> bfExists(K key, V item);

	Mono<BloomFilterInfo> bfInfo(K key);

	Mono<Long> bfInfo(K key, BloomFilterInfoType type);

	Flux<Boolean> bfInsert(K key, V... items);

	Flux<Boolean> bfInsert(K key, BloomFilterInsertOptions options, V... items);

	Flux<Boolean> bfMAdd(K key, V... items);

	Flux<Boolean> bfMExists(K key, V... items);

	Mono<String> bfReserve(K key, double errorRate, long capacity);

	Mono<String> bfReserve(K key, double errorRate, long capacity, BloomFilterReserveOptions options);

	Mono<Boolean> cfAdd(K key, V item);

	Mono<Boolean> cfAddNx(K key, V item);

	Mono<Long> cfCount(K key, V item);

	Mono<Boolean> cfDel(K key, V item);

	Mono<Boolean> cfExists(K key, V item);

	Mono<CuckooFilter> cfInfo(K key);

	Flux<Long> cfInsert(K key, V... items);

	Flux<Long> cfInsert(K key, CuckooFilterInsertOptions options, V... items);

	Flux<Long> cfInsertNx(K key, V... items);

	Flux<Long> cfInsertNx(K key, CuckooFilterInsertOptions options, V... items);

	Flux<Boolean> cfMExists(K key, V... items);

	Mono<String> cfReserve(K key, long capacity);

	Mono<String> cfReserve(K key, long capacity, CuckooFilterReserveOptions options);

	Mono<Long> cmsIncrBy(K key, V item, long increment);

	Flux<Long> cmsIncrBy(K key, LongScoredValue<V>... itemIncrements);

	Mono<String> cmsInitByProb(K key, double error, double probability);

	Mono<String> cmsInitByDim(K key, long width, long depth);

	Flux<Long> cmsQuery(K key, V... items);

	Mono<String> cmsMerge(K destKey, K... keys);

	Mono<String> cmsMerge(K destKey, LongScoredValue<K>... sourceKeyWeights);

	Mono<CmsInfo> cmsInfo(K key);

	Flux<Value<V>> topKAdd(K key, V... items);

	Flux<Value<V>> topKIncrBy(K key, LongScoredValue<V>... itemIncrements);

	Mono<TopKInfo> topKInfo(K key);

	Flux<String> topKList(K key);

	Flux<KeyValue<String, Long>> topKListWithScores(K key);

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

	Flux<Long> tDigestRevRank(K key, double... values);

	Mono<Double> tDigestTrimmedMean(K key, double lowCutQuantile, double highCutQuantile);
}
