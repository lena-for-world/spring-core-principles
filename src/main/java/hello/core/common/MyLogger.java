package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value="request")
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + " [ " + requestURL + "]" + message);
    }

    @PostConstruct
    public void init() {
        // getobject되면 request scope bean이 생성되면서 http request랑 uuid를 연결시킴
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "]" + "request scope bean create " + this);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("[" + uuid + "]" + "request scope bean destroy " + this);
    }
}
