package cn.kerry.sharestudio.base;

/**
 * Created by Administrator on 2017/3/8.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

    void showError(String msg);

}
