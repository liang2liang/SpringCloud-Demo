import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.Observer;


/**
 * @author maoliang
 * @version 1.0.0
 */
@Slf4j
public class RxTest {

    public static void main(String[] args) {
        //创建被观察者
        Observable<String> observable = Observable.create(subscriber -> {
            //调用观察者的回调
            subscriber.onNext("我是");
            subscriber.onNext("RxJava");
            subscriber.onNext("简单示例");
            subscriber.onError(new Throwable("出错了"));
            subscriber.onError(new Throwable("出错了"));

//            subscriber.onCompleted();
//            subscriber.onCompleted();
//            subscriber.onCompleted();
        });

        //创建观察者
        Observer<String> observer = new Observer<String>() {

            @Override
            public void onCompleted() {
                log.info("completed");
            }

            @Override
            public void onError(Throwable e) {
                log.error("onError", e);
            }


            @Override
            public void onNext(String s) {
                log.info(s);
            }
        };

        //注册，将观察者和被观察者关联，将会触发OnSubscribe.call方法
        observable.subscribe(observer);

    }

}
