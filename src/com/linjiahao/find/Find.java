package com.linjiahao.find;
import com.linjiahao.util.DoubleMap;
import com.linjiahao.util.Union;

import java.util.ArrayList;
import java.util.Set;
public class Find {
	private DoubleMap<String, String, Integer> doubleMap;
	public Find(DoubleMap<String, String, Integer> doubleMap) {
		this.doubleMap = doubleMap;
	}
	public String next(String startingPoint, String endPoint) {
		ArrayList<String> point = new ArrayList<>();
		ArrayList<Double> price = new ArrayList<>();
		Union<ArrayList<String>, ArrayList<Double>> union = new Union<>(point, price);
		point.add(startingPoint);
		getNext(startingPoint, endPoint, union, 1);
		return null;
	}
	private void getNext(String startingPoint, String endPoint, Union<ArrayList<String>, ArrayList<Double>> union, int times) {
		if (times > 17) {
			return;
		}
		String s = union.first.get(union.first.size() - 1).equals(endPoint) ? startingPoint : union.first.get(union.first.size() - 1);
		Set<String> key2Set = doubleMap.getKey2Set(s);
		Union<ArrayList<String>, ArrayList<Double>> collect = key2Set.stream().collect(() -> {
			ArrayList<String> pointArrayList = new ArrayList<>(union.first);
			ArrayList<Double> priceArrayList = new ArrayList<>(union.second);
			return new Union<>(pointArrayList, priceArrayList);
		}, (newUnion, item) -> {
			newUnion.first.add(item);
			newUnion.second.add(doubleMap.get(s, item) * (times > 15 ? 0.6 : 0.95));
			getNext(startingPoint, endPoint, newUnion, times + 1);
		}, (item1, item2) -> {
			double sum1 = item1.second.stream().mapToDouble(Double::doubleValue).sum();
			double sum2 = item2.second.stream().mapToDouble(Double::doubleValue).sum();
			if (sum1 > sum2) {
				item1.first = item2.first;
				item1.second = item2.second;
			}
		});
	}
}
