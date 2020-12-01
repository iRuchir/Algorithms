package com.ruchir.google.adhoc;

import java.util.ArrayList;
import java.util.List;

public class Meetings {

	List<Integer> effectiveBounds;

	/*
	 * Sample Input [["9:00", "10:30"], ["12:00", "13:00"], ["16:00", "18:00"]]
	 * ["9:00", "20:00"]
	 * 
	 * [["10:00", "11:30"], ["12:30", "14:30"], ["14:30", "15:00"], ["16:00",
	 * "17:00"]] ["10:00", "18:30"]
	 * 
	 * 30
	 * 
	 * Sample output: [["11:30", "12:00"], ["15:00", "16:00"], ["18:00", "18:30"]]
	 * 
	 */

	/*
	 * - Get common free time - Get effective bounds
	 */

	public List<List<Integer>> findCommonSlots(List<List<Integer>> freeSlots1, List<List<Integer>> freeSlots2,
			int meetingDuration) {
		List<List<Integer>> commonSlots = new ArrayList<List<Integer>>();
		List<Integer> slot;
		List<Integer> slot1;
		List<Integer> slot2;

		int min;
		int max;
		int diff;

		for (int i = 0; i < freeSlots1.size(); i++) {
			slot1 = freeSlots1.get(i);
			for (int j = 0; j < freeSlots2.size(); j++) {
				slot2 = freeSlots2.get(j);
				min = (slot1.get(0) >= slot2.get(0) ? slot1.get(0) : slot2.get(0));
				max = (slot1.get(1) <= slot2.get(1) ? slot1.get(1) : slot2.get(1));
				System.out.println(slot1 + "," + slot2 + ":" + min + "," + max);
				diff = max - min;
				System.out.print(diff+":");
				if (Math.abs(diff) >= 100) {
					diff = diff - ((diff/100)*40);
				}
				System.out.println(diff);
				if (diff >= meetingDuration) {
					slot = new ArrayList<Integer>();
					slot.add(min);
					slot.add(max);
					commonSlots.add(slot);
					continue;
				}

			}
		}

		return commonSlots;
	}

	public List<List<Integer>> getFreeSlots(List<List<Integer>> busySlots, int meetingDuration) {
		List<List<Integer>> freeSlots = new ArrayList<List<Integer>>();
		List<Integer> slot;
		int effectiveStartTime = effectiveBounds.get(0);
		int effectiveEndTime = effectiveBounds.get(1);
		int previousSlotEndTime = effectiveStartTime;

		for (List<Integer> busySlot : busySlots) {
			slot = new ArrayList<Integer>();
			if (previousSlotEndTime >= effectiveEndTime) {
				break;
			}
			if ((busySlot.get(0) - previousSlotEndTime) >= meetingDuration) {
				slot.add(previousSlotEndTime);
				slot.add(busySlot.get(0));
				freeSlots.add(slot);
			}
			previousSlotEndTime = busySlot.get(1);
		}
		if (effectiveEndTime - previousSlotEndTime >= meetingDuration) {
			slot = new ArrayList<Integer>();
			slot.add(previousSlotEndTime);
			slot.add(effectiveEndTime);
			freeSlots.add(slot);
		}
		System.out.println(freeSlots);

		return freeSlots;

	}

	public List<Integer> getEffectiveBounds(List<Integer> dailyBound1, List<Integer> dailyBound2) {
		effectiveBounds = new ArrayList<Integer>();

		effectiveBounds.add((dailyBound1.get(0) >= dailyBound2.get(0)) ? dailyBound1.get(0) : dailyBound2.get(0));
		effectiveBounds.add((dailyBound1.get(1) <= dailyBound2.get(1)) ? dailyBound1.get(1) : dailyBound2.get(1));

		return effectiveBounds;
	}
}
