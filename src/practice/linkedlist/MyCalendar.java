package practice.linkedlist;

public class MyCalendar {
    private Event head;
    static class Event {
        int start;
        int end;
        Event next;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
            this.next = null;
        }
    }

    public MyCalendar() {
        head = null;
    }

    public boolean book(int start, int end) {
        if (head == null) head = new Event(start, end);
        else {
            Event headCopy = head;
            Event prv = null;
            while (headCopy != null) {
                if (end <= headCopy.start || start >= headCopy.end) {
                    prv = headCopy;
                    headCopy = headCopy.next;
                }
                else return false;
            }
            prv.next = new Event(start, end);
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // return True
        System.out.println(myCalendar.book(15, 25)); // return False, It can not be booked because time 15 is already booked by another event.
        System.out.println(myCalendar.book(20, 30));
    }
}
