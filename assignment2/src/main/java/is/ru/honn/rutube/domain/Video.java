package is.ru.honn.rutube.domain;

import java.util.List;
import java.util.StringJoiner;


public class Video {

  int videoId;
  String title;
  String description;
  String source;
  String videoType;
  List<String> tags;

  public Video(int videoId, String title, String description, String source, String videoType, List<String> tags) {
    this.videoId = videoId;
    this.title = title;
    this.description = description;
    this.source = source;
    this.videoType = videoType;
    this.tags = tags;
  }

  public void setVideoId(int videoId) {
    this.videoId = videoId;
  }

  public int getVideoId()
  {
    return videoId;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return this.title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getSource() {
    return this.source;
  }

  public void setVideoType(String videoType) {
    this.videoType = videoType;
  }

  public String getVideoType() {
    return this.videoType;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public List<String> getTags() {
    return this.tags;
  }

  public void addTag(String tag){
    tags.add(tag);
  }

}

