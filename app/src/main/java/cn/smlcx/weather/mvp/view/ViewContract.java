package cn.smlcx.weather.mvp.view;

import java.util.List;

import cn.smlcx.weather.Base.BaseView;
import cn.smlcx.weather.Bean.ChoiceBean;
import cn.smlcx.weather.Bean.NewsBean;
import cn.smlcx.weather.Bean.WeatherBean;

/**
 * Created by lcx on 2017/5/5.
 */

public interface ViewContract {
    interface ChoiceListView extends BaseView{
        void showChoiceList(List<ChoiceBean.ResultBean.ListBean> mList);
    }

    interface NewsListView extends BaseView{
        void showNewsList(List<NewsBean.ResultBean.DataBean> mList);
    }

    interface WeatherView extends BaseView{
        void showWeather(WeatherBean bean);
    }
}
