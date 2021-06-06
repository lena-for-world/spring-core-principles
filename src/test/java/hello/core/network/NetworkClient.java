package hello.core.network;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    String url;

    public NetworkClient() {
        System.out.println("생성자 호출 url = " + url);
    }

    void connect() {
        System.out.println("connect = " + url);
    }

    void call(String message) {
        System.out.println("call: "+ url + " message = " + message);
    }

    void setUrl(String web) {
        this.url = web;
    }

    void disconnect() {
        System.out.println("close = " + url);
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    //@Override
    //public void afterPropertiesSet() throws Exception{
        // implements InitializingBean
        // 의존관계주입 이후 실행되는 메서드
        // 의존관계주입이 끝나면 호출되는 메서드! InitializingBean에 등록되어 있음
    //    System.out.println("");
    //}

   /* @Override
    public void destroy() throws Exception {
        // implements DisposableBean
        // DisposableBean에 등록된 소멸 메서드
        System.out.println("ssibal");
        disconnect();
    }*/
}
