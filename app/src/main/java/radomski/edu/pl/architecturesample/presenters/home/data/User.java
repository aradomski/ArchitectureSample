package radomski.edu.pl.architecturesample.presenters.home.data;

import radomski.edu.pl.architecturesample.api.dev.data.ApiUser;

public class User {
    private String login;
    private Integer id;
    private String avatarUrl;
    private String gravatarId;
    private String url;
    private String htmlUrl;
    private String followersUrl;
    private String followingUrl;
    private String gistsUrl;
    private String starredUrl;
    private String subscriptionsUrl;
    private String organizationsUrl;
    private String reposUrl;
    private String eventsUrl;
    private String receivedEventsUrl;
    private String type;
    private Boolean siteAdmin;
    private String name;
    private Object company;
    private Object blog;
    private Object location;
    private String email;
    private Object hireable;
    private Object bio;
    private Integer publicRepos;
    private Integer publicGists;
    private Integer followers;
    private Integer following;
    private String createdAt;
    private String updatedAt;


    public User(ApiUser other) {
        this.login = other.getLogin();
        this.id = other.getId();
        this.avatarUrl = other.getAvatarUrl();
        this.gravatarId = other.getGravatarId();
        this.url = other.getUrl();
        this.htmlUrl = other.getHtmlUrl();
        this.followersUrl = other.getFollowersUrl();
        this.followingUrl = other.getFollowingUrl();
        this.gistsUrl = other.getGistsUrl();
        this.starredUrl = other.getStarredUrl();
        this.subscriptionsUrl = other.getSubscriptionsUrl();
        this.organizationsUrl = other.getOrganizationsUrl();
        this.reposUrl = other.getReposUrl();
        this.eventsUrl = other.getEventsUrl();
        this.receivedEventsUrl = other.getReceivedEventsUrl();
        this.type = other.getType();
        this.siteAdmin = other.getSiteAdmin();
        this.name = other.getName();
        this.company = other.getCompany();
        this.blog = other.getBlog();
        this.location = other.getLocation();
        this.email = other.getEmail();
        this.hireable = other.getHireable();
        this.bio = other.getBio();
        this.publicRepos = other.getPublicRepos();
        this.publicGists = other.getPublicGists();
        this.followers = other.getFollowers();
        this.following = other.getFollowing();
        this.createdAt = other.getCreatedAt();
        this.updatedAt = other.getUpdatedAt();
    }


    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gravatarId='" + gravatarId + '\'' +
                ", url='" + url + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", followersUrl='" + followersUrl + '\'' +
                ", followingUrl='" + followingUrl + '\'' +
                ", gistsUrl='" + gistsUrl + '\'' +
                ", starredUrl='" + starredUrl + '\'' +
                ", subscriptionsUrl='" + subscriptionsUrl + '\'' +
                ", organizationsUrl='" + organizationsUrl + '\'' +
                ", reposUrl='" + reposUrl + '\'' +
                ", eventsUrl='" + eventsUrl + '\'' +
                ", receivedEventsUrl='" + receivedEventsUrl + '\'' +
                ", type='" + type + '\'' +
                ", siteAdmin=" + siteAdmin +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", blog=" + blog +
                ", location=" + location +
                ", email='" + email + '\'' +
                ", hireable=" + hireable +
                ", bio=" + bio +
                ", publicRepos=" + publicRepos +
                ", publicGists=" + publicGists +
                ", followers=" + followers +
                ", following=" + following +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
