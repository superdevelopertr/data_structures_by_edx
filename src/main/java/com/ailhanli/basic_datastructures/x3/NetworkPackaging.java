package com.ailhanli.basic_datastructures.x3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Package implements Comparable<Package> {

	private Integer arriveTime;

	private Integer processingTime;

	public Package(Integer arriveTime, Integer processingTime) {
		super();
		this.arriveTime = arriveTime;
		this.processingTime = processingTime;
	}

	public Integer getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(Integer arriveTime) {
		this.arriveTime = arriveTime;
	}

	public Integer getProcessingTime() {
		return processingTime;
	}

	public void setProcessingTime(Integer processingTime) {
		this.processingTime = processingTime;
	}

	@Override
	public int compareTo(Package o) {
		return Integer.compare(arriveTime, o.arriveTime);
	}

}

public class NetworkPackaging {

	public int[] simulate(List<String> items) {
		if(items.size()==0 || items.size()==1){
			return null;
		}
		
		String[] sizes  = items.get(0).split(" ");
		Integer size = Integer.parseInt(sizes[0]);
		Integer numberOfItems = Integer.parseInt(sizes[1]);
		
		PriorityQueue<Package> packageQueue = new PriorityQueue<>();
		List<Integer> timeQueue = new ArrayList<>(size);
		timeQueue.add(0);

		for (int i = 1; i < items.size(); i++) {
			String[] itemInfo = items.get(i).split(" ");
			Integer arriveTime = Integer.valueOf(itemInfo[0]);
			Integer processingTime = Integer.valueOf(itemInfo[1]);
			packageQueue.offer(new Package(arriveTime, processingTime));
		}

		while(!packageQueue.isEmpty()){
			Package pack = packageQueue.poll();
			Integer lastTime = timeQueue.remove(0);
			if(pack.getArriveTime()>=lastTime){
				lastTime = lastTime+pack.getProcessingTime();
				timeQueue.add(lastTime);
			}else{
				
			}
			
		}
		
		return null;
	}

}