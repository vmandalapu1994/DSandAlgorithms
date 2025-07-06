package MergeIntervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * You’re given a list containing the schedules of multiple employees.
 * Each person’s schedule is a list of non-overlapping intervals in sorted order.
 * An interval is specified with the start and end time, both being positive integers.
 * Your task is to find the list of finite intervals representing the free time for all the employees.
 * <p>
 * Note: The common free intervals are calculated between the earliest start time and the latest end time of
 * all meetings across all employees.
 */

public class EmployeeFreeTime {

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> nonoverlappingSchedule = schedule.get(0);

        for (int i = 1; i < schedule.size(); i++) {
            for (int j = 0; j < schedule.get(i).size(); j++) {
                nonoverlappingSchedule = insertInterval(nonoverlappingSchedule, schedule.get(i).get(j));
            }
        }

        Interval prev = nonoverlappingSchedule.get(0);

        List<Interval> ans = new ArrayList<Interval>();

        for (int i = 1; i < nonoverlappingSchedule.size(); i++) {
            if (prev.end < nonoverlappingSchedule.get(i).start) {
                ans.add(new Interval(prev.end, nonoverlappingSchedule.get(i).start));
            }
            prev = nonoverlappingSchedule.get(i);
        }

        return ans;
    }

    public static List<Interval> employeeFreeTimeOptimized(List<List<Interval>> schedule) {

        List<Interval> allIntervals = schedule.stream().flatMap(intervals -> intervals.stream()).collect(Collectors.toList());

        allIntervals.sort((a, b) -> {
            if (a.start != b.start) {
                return Integer.compare(a.start, b.start);
            }
            return Integer.compare(a.end, b.end);
        });

        List<Interval> nonoverlappingSchedule = mergeIntervals(allIntervals);

        Interval prev = nonoverlappingSchedule.get(0);

        List<Interval> ans = new ArrayList<>();

        for (int i = 1; i < nonoverlappingSchedule.size(); i++) {
            if (prev.end < nonoverlappingSchedule.get(i).start) {
                ans.add(new Interval(prev.end, nonoverlappingSchedule.get(i).start));
            }
            prev = nonoverlappingSchedule.get(i);
        }

        return ans;

    }

    public static List<Interval> employeeFreeTimeOptimizedUsingHeap(List<List<Interval>> schedule) {

        PriorityQueue<PQEntry> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.interval.start != b.interval.start) {
                return Integer.compare(a.interval.start, b.interval.start);
            }
            return Integer.compare(a.interval.end, b.interval.end);
        });

        for (int i = 0; i < schedule.size(); i++) {
            minHeap.add(new PQEntry(schedule.get(i).get(0), i, 0));
        }

        List<Interval> nonOverlapping = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            PQEntry entry = minHeap.poll();

            Interval prev = nonOverlapping.isEmpty() ? null : nonOverlapping.get(nonOverlapping.size() - 1);

            if (prev != null && prev.end >= entry.interval.start) {
                prev.end = Math.max(prev.end, entry.interval.end);
            } else {
                nonOverlapping.add(entry.interval);
            }
            if (schedule.get(entry.empIndex).size() > entry.intervalIndex + 1) {
                minHeap.add(new PQEntry(schedule.get(entry.empIndex).get(entry.intervalIndex + 1), entry.empIndex, entry.intervalIndex + 1));
            }
        }

        List<Interval> freeTime = new ArrayList<>();

        for (int i = 1; i < nonOverlapping.size(); i++) {
            if (nonOverlapping.get(i).start > nonOverlapping.get(i - 1).end) {
                freeTime.add(new Interval(nonOverlapping.get(i - 1).end, nonOverlapping.get(i).start));
            }
        }

        return freeTime;

    }


    public static List<Interval> mergeIntervals(List<Interval> allIntervals) {
        List<Interval> nonOverlapping = new ArrayList<>();
        for (Interval i : allIntervals) {
            if (nonOverlapping.isEmpty()) {
                nonOverlapping.add(i);
                continue;
            }
            Interval last = nonOverlapping.get(nonOverlapping.size() - 1);
            if (last.end >= i.start) {
                last.end = Math.max(i.end, last.end);
            } else {
                nonOverlapping.add(i);
            }
        }
        return nonOverlapping;
    }


    public static List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
        List<Interval> output = new ArrayList<>();
        int n = intervals.size();
        int i = 0;
        while (i < n && intervals.get(i).end < newInterval.start) {
            output.add(intervals.get(i));
            i++;
        }
        while (i < n && newInterval.end >= intervals.get(i).start) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        output.add(newInterval);
        while (i < n) {
            output.add(intervals.get(i));
            i++;
        }
        return output;
    }
}

class Interval {
    int start;
    int end;
    boolean closed;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
        this.closed = true; // by default, the interval is closed
    }

    public String toString() {
        return "[" + start + "," + end + "]";
    }

    // set the flag for closed/open
    public void setClosed(boolean closed) {
        this.closed = closed;
    }

}

class PQEntry {

    Interval interval;

    int empIndex;

    int intervalIndex;

    PQEntry(Interval interval, int empIndex, int intervalIndex) {
        this.interval = interval;
        this.empIndex = empIndex;
        this.intervalIndex = intervalIndex;
    }

}


