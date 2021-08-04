package com.example.sqliteapplication;

public class Student {

        String name, dob, contact;

        public Student(String name, String dob, String contact) {

            this.name = name;
            this.dob = dob;
            this.contact = contact;
        }

        public String getName() {
            return name;
        }

        public String getDob() {
            return dob;
        }

        public String getContact() {
            return contact;
        }
}
