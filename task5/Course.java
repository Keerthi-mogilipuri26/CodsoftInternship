class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    int enrolled;
    String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolled = 0;
    }

    public boolean isFull() {
        return enrolled >= capacity;
    }

    public void enroll() {
        if (!isFull()) {
            enrolled++;
        }
    }

    public void drop() {
        if (enrolled > 0) {
            enrolled--;
        }
    }

    public int availableSlots() {
        return capacity - enrolled;
    }

    @Override
    public String toString() {
        return courseCode + ": " + title + " (" + enrolled + "/" + capacity + " slots taken)\n"
             + "Description: " + description + "\n"
             + "Schedule: " + schedule + "\n"
             + "Available Slots: " + availableSlots() + "\n";
    }
}
