package cn.smlcx.weather.di.component;

import cn.smlcx.weather.di.module.NewsModule;
import cn.smlcx.weather.di.scope.FragmentScope;
import cn.smlcx.weather.ui.fragment.CommonNewsFragment;
import cn.smlcx.weather.ui.fragment.PersonalFragment;
import dagger.Component;

/**
 * Created by lcx on 2017/5/8.
 */
@FragmentScope
@Component(modules = NewsModule.class)
public interface NewsComponent {
    void inject(CommonNewsFragment fragment);
}
