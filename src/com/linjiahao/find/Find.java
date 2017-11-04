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
		getNext(startingPoint, endPoint, union, 1, 0);
		String str = union.first.stream().reduce((string, s) -> string + " 到 " + s).orElse("");
		double sumPrice = union.second.stream().mapToDouble(Double::doubleValue).sum();
		return str + "，总价钱为：" + String.format("%.2f", sumPrice);
	}
	private void getNext(String startingPoint, String endPoint, Union<ArrayList<String>, ArrayList<Double>> union, int times, int arriveTimes) {
		final String s;
		String arrive = union.first.get(union.first.size() - 1);
		if (arrive.equals(endPoint)) {
			arriveTimes++;
			s = startingPoint;
		} else {
			s = arrive;
		}
		if (arriveTimes > 17) {
			System.out.println(union.first);
			System.out.println(union.second);
			System.out.println(union.second.stream().mapToDouble(Double::doubleValue).sum());
			System.out.println(arriveTimes);
			return;
		}
		Set<String> key2Set = doubleMap.getKey2Set(s);
		int finalArriveTimes = arriveTimes;
		Union<ArrayList<String>, ArrayList<Double>> reduce = key2Set.parallelStream().map((item) -> {
			ArrayList<String> pointArrayList = new ArrayList<>(union.first);
			ArrayList<Double> priceArrayList = new ArrayList<>(union.second);
			pointArrayList.add(item);
			priceArrayList.add(doubleMap.get(s, item) * (times > 15 ? 0.6 : 0.95));
			Union<ArrayList<String>, ArrayList<Double>> listUnion = new Union<>(pointArrayList, priceArrayList);
			double sum2 = listUnion.second.stream().mapToDouble(Double::doubleValue).sum();
			if (sum2 <= 80.25) {
				getNext(startingPoint, endPoint, listUnion, times + 1, finalArriveTimes);
			}
			return listUnion;
		}).reduce(null, (item1, item2) -> {
			if (item1 == null) {
				return item2;
			}
			if (item2 == null) {
				return item1;
			}
			double sum1 = item1.second.stream().mapToDouble(Double::doubleValue).sum();
			double sum2 = item2.second.stream().mapToDouble(Double::doubleValue).sum();
			if (sum1 > sum2) {
				return item2;
			}
			return item1;
		});
		//		Union<ArrayList<String>, ArrayList<Double>> collect = key2Set.stream().collect(() -> {
		//			ArrayList<String> pointArrayList = new ArrayList<>(union.first);
		//			ArrayList<Double> priceArrayList = new ArrayList<>(union.second);
		//			return new Union<>(pointArrayList, priceArrayList);
		//		}, (newUnion, item) -> {
		//			newUnion.first.add(item);
		//			newUnion.second.add(0.0);
		//			getNext(startingPoint, endPoint, newUnion, times + 1, finalArriveTimes);
		//		}, (item1, item2) -> {
		//			double sum1 = item1.second.stream().mapToDouble(Double::doubleValue).sum();
		//			double sum2 = item2.second.stream().mapToDouble(Double::doubleValue).sum();
		//			if (sum1 > sum2) {
		//				item1.first = item2.first;
		//				item1.second = item2.second;
		//			}
		//		});
		union.first = reduce.first;
		union.second = reduce.second;
	}
}
