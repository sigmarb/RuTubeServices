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

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getUserId() {
    return this.userId;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return this.email;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return this.displayName;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public LocalDate getBirthDate() {
    return this.birthDate;
  }

  public void setVideos(List<Video> videos){
    this.videos = videos;
  }

  public List<Video>getVideos()
  {
    return videos;
  }

  public void addVideo(Video v)
  {
    videos.add(v);
  }
}


