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
package ai.rideos.android.common.reactive;

import io.reactivex.Observable;
import java.util.concurrent.atomic.AtomicInteger;
import org.mockito.ArgumentMatcher;

public class TestUtils {

    public static <T> Observable<T> throwUntilLastRetryObservable(final int numRetries,
                                                                  final T successfulResponse,
                                                                  final Exception exception) {
        final AtomicInteger count = new AtomicInteger(0);
        return Observable.fromCallable(() -> {
            if (count.incrementAndGet() > numRetries) {
                return successfulResponse;
            }
            throw exception;
        });
    }

    public static <T> ArgumentMatcher<Result<T>> matchResultWithOutcome(final boolean isSuccess) {
        return new ArgumentMatcher<Result<T>>() {
            @Override
            public boolean matches(final Object argument) {
                return argument instanceof Result && ((Result) argument).isSuccess() == isSuccess;
            }
        };
    }
}