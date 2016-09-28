package is.ru.honn.rutube.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.*;

public class User {


  int userId;
  String firstName;
  String lastName;
  String email;
  String displayName;
  LocalDate birthDate;
  List<Video> videos;

  public User(int userId, String firstName, String lastName, String email, String displayName, String birthDate) {
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.displayName = displayName;
    this.birthDate = parse(birthDate);
    videos = new ArrayList<Video>();

  }
  public void setVideos(List<Video> videos){
    this.videos = videos;
  }
}
