package cn.kerry.sharestudio.base;

/**
 * Created by Administrator on 2017/3/8.
 */

public interface BasePresenter<T> {

    void attatchView(T view);

    void detacheView();

}
