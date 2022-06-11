import java.util.*;
class Pair implements Comparable<Pair> {
	int start, end;
	public Pair(int i, int j){
		start = i;
		end = j;
	}
	@Override
	public int compareTo(Pair b){
		return this.start == b.start ? this.end - b.end : this.start - b.start;
	}
}

class MyCalendar {
    TreeSet<Pair> set;
    public MyCalendar() {
        set = new TreeSet<>();
    }
    
    public boolean book(int start, int end) {
        Pair temp = new Pair(start, end);
        if(set.contains(temp)) return false;
        Pair low = set.lower(temp);
        if(low != null && low.end > temp.start) return false;
        Pair high = set.higher(temp);
        if(high != null && high.start < temp.end) return false;
        set.add(temp);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */