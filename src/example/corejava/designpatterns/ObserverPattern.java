package example.corejava.designpatterns;

import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void update(String videoTitle);
}
class User implements Subscriber {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(name + " received notification: New video uploaded - " + videoTitle);
    }
}
class Channel {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String channelName;

    public Channel(String channelName) {
        this.channelName = channelName;
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void uploadVideo(String videoTitle) {
        System.out.println("Channel " + channelName + ": Uploaded new video - " + videoTitle);
        notifySubscribers(videoTitle);
    }

    private void notifySubscribers(String videoTitle) {
        for (Subscriber s : subscribers) {
            s.update(videoTitle);
        }
    }
}
public class ObserverPattern {
    public static void main(String[] args) {
        Channel channel = new Channel("TechWithJava");

        User u1 = new User("Alice");
        User u2 = new User("Bob");

        channel.subscribe(u1);
        channel.subscribe(u2);

        channel.uploadVideo("Observer Pattern Explained!");
    }
}
