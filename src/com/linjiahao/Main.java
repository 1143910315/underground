package com.linjiahao;
import com.linjiahao.find.Find;
import com.linjiahao.util.DoubleMap;
public class Main {
	public static void main(String[] args) {
		DoubleMap<String, String, Integer> doubleMap = new DoubleMap<>();
		//0.95
		//0.6
		// 小北路线
		doubleMap.put("小北", "淘金", 2);
		doubleMap.put("小北", "区庄", 2);
		doubleMap.put("小北", "动物园", 2);
		doubleMap.put("小北", "杨箕", 3);
		doubleMap.put("小北", "五羊邨", 3);
		doubleMap.put("小北", "珠江新城", 3);
		doubleMap.put("小北", "猎德", 3);
		doubleMap.put("小北", "潭村", 4);
		doubleMap.put("小北", "员村", 4);
		doubleMap.put("小北", "科韵路", 5);
		doubleMap.put("小北", "车陂南", 5);
		doubleMap.put("小北", "万胜围", 5);
		// 淘金路线
		doubleMap.put("淘金", "区庄", 2);
		doubleMap.put("淘金", "动物园", 2);
		doubleMap.put("淘金", "杨箕", 2);
		doubleMap.put("淘金", "五羊邨", 3);
		doubleMap.put("淘金", "珠江新城", 3);
		doubleMap.put("淘金", "猎德", 3);
		doubleMap.put("淘金", "潭村", 3);
		doubleMap.put("淘金", "员村", 4);
		doubleMap.put("淘金", "科韵路", 4);
		doubleMap.put("淘金", "车陂南", 5);
		doubleMap.put("淘金", "万胜围", 5);
		// 区庄路线
		doubleMap.put("区庄", "动物园", 2);
		doubleMap.put("区庄", "杨箕", 2);
		doubleMap.put("区庄", "五羊邨", 2);
		doubleMap.put("区庄", "珠江新城", 3);
		doubleMap.put("区庄", "猎德", 3);
		doubleMap.put("区庄", "潭村", 3);
		doubleMap.put("区庄", "员村", 4);
		doubleMap.put("区庄", "科韵路", 4);
		doubleMap.put("区庄", "车陂南", 4);
		doubleMap.put("区庄", "万胜围", 5);
		// 动物园路线
		doubleMap.put("动物园", "杨箕", 2);
		doubleMap.put("动物园", "五羊邨", 2);
		doubleMap.put("动物园", "珠江新城", 2);
		doubleMap.put("动物园", "猎德", 3);
		doubleMap.put("动物园", "潭村", 3);
		doubleMap.put("动物园", "员村", 3);
		doubleMap.put("动物园", "科韵路", 4);
		doubleMap.put("动物园", "车陂南", 4);
		doubleMap.put("动物园", "万胜围", 5);
		// 杨箕路线
		doubleMap.put("杨箕", "五羊邨", 2);
		doubleMap.put("杨箕", "珠江新城", 2);
		doubleMap.put("杨箕", "猎德", 2);
		doubleMap.put("杨箕", "潭村", 3);
		doubleMap.put("杨箕", "员村", 3);
		doubleMap.put("杨箕", "科韵路", 3);
		doubleMap.put("杨箕", "车陂南", 4);
		doubleMap.put("杨箕", "万胜围", 4);
		// 五羊邨路线
		doubleMap.put("五羊邨", "珠江新城", 2);
		doubleMap.put("五羊邨", "猎德", 2);
		doubleMap.put("五羊邨", "潭村", 2);
		doubleMap.put("五羊邨", "员村", 3);
		doubleMap.put("五羊邨", "科韵路", 3);
		doubleMap.put("五羊邨", "车陂南", 3);
		doubleMap.put("五羊邨", "万胜围", 4);
		// 珠江新城路线
		doubleMap.put("珠江新城", "猎德", 2);
		doubleMap.put("珠江新城", "潭村", 2);
		doubleMap.put("珠江新城", "员村", 3);
		doubleMap.put("珠江新城", "科韵路", 3);
		doubleMap.put("珠江新城", "车陂南", 3);
		doubleMap.put("珠江新城", "万胜围", 4);
		// 猎德路线
		doubleMap.put("猎德", "潭村", 2);
		doubleMap.put("猎德", "员村", 2);
		doubleMap.put("猎德", "科韵路", 3);
		doubleMap.put("猎德", "车陂南", 3);
		doubleMap.put("猎德", "万胜围", 4);
		// 潭村路线
		doubleMap.put("潭村", "员村", 2);
		doubleMap.put("潭村", "科韵路", 2);
		doubleMap.put("潭村", "车陂南", 3);
		doubleMap.put("潭村", "万胜围", 3);
		// 员村路线
		doubleMap.put("员村", "科韵路", 2);
		doubleMap.put("员村", "车陂南", 2);
		doubleMap.put("员村", "万胜围", 3);
		// 科韵路路线
		doubleMap.put("科韵路", "车陂南", 2);
		doubleMap.put("科韵路", "万胜围", 2);
		// 车陂南路线
		doubleMap.put("车陂南", "万胜围", 2);
		Find find = new Find(doubleMap);
		System.out.println(find.next("小北","万胜围"));
	}
}

