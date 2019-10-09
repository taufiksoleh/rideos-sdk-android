/**
 * Copyright 2018-2019 rideOS, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ai.rideos.android.driver_app.online.waiting_for_pickup;

import ai.rideos.android.common.viewmodel.ViewModel;
import ai.rideos.android.common.viewmodel.map.MapStateProvider;
import ai.rideos.android.common.viewmodel.progress.ProgressSubject.ProgressState;
import ai.rideos.android.driver_app.online.OnTripViewModel;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface WaitingForPickupViewModel extends MapStateProvider, ViewModel, OnTripViewModel {
    void openTripDetails();

    Single<Boolean> shouldShowTripDetailTutorial();

    void confirmPickup();

    Observable<ProgressState> getConfirmingPickupProgress();
}
