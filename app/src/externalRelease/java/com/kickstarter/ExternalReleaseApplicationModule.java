package com.kickstarter;

import com.kickstarter.libs.ApiEndpoint;
import com.kickstarter.libs.BuildCheck;
import com.kickstarter.libs.NoopBuildCheck;
import com.kickstarter.ui.containers.ApplicationContainer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ApplicationModule.class)
public class ExternalReleaseApplicationModule {
  @Singleton
  @Provides
  ApplicationContainer provideApplicationContainer() {
    return ApplicationContainer.DEFAULT;
  }

  @Provides
  @Singleton
  ApiEndpoint provideApiEndpoint() {
    return ApiEndpoint.PRODUCTION;
  }

  @Provides
  BuildCheck provideBuildCheck() {
    return new NoopBuildCheck();
  }
}