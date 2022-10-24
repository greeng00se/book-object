package ch12;

import org.junit.jupiter.api.Test;

import java.util.List;

class LectureTest {

    @Test
    void count() {
        Lecture lecture = new Lecture("객체지향 프로그래밍", 70, List.of(81, 95, 75, 50, 45));

        String result = lecture.evaluate();

        System.out.println(result);
    }

}
