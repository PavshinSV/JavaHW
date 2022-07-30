package Lesson05Task02;

public class Song {
    private String style;
    private String name;
    private Integer listenCount;

    public Song(String style, String name, Integer listenCount){
        this.style=style;
        this.name=name;
        this.listenCount=listenCount;
    }

    public String getStyle(){
        return style;
    }

    public String getName(){
        return name;
    }

    public Integer getListenCount(){
        return listenCount;
    }

    @Override
    public String toString() {
        return String.format("Style: %s; Song name: %s; Count of listen: %d", style,name,listenCount);
    }
}
