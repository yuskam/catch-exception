/**
 * Copyright (C) 2011 rwoo@gmx.de
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.catchexception.internal;

import org.mockito.cglib.proxy.MethodInterceptor;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.creation.jmock.ClassImposterizer;

/**
 * This {@link ProxyFactory} uses Mockito's jmock package to create proxies that
 * subclass from the target's class.
 * 
 * @author rwoo
 */
public class SubclassProxyFactory implements ProxyFactory {

    /**
     * That proxy factory is used if this factory cannot be used.
     */
    private ProxyFactory fallbackProxyFactory = new InterfaceOnlyProxyFactory();

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.googlecode.catchexception.internal.ProxyFactory#createProxy(java.
     * lang.Object, java.lang.Class, boolean)
     */
    @SuppressWarnings("unchecked")
    public <T> T createProxy(Class<?> targetClass, MethodInterceptor interceptor) {

        // can we subclass the class of the target?
        if (!ClassImposterizer.INSTANCE.canImposterise(targetClass)) {

            // delegate
            return fallbackProxyFactory.<T> createProxy(targetClass,
                    interceptor);
        }

        // create proxy
        T proxy;
        try {

            proxy = (T) ClassImposterizer.INSTANCE.imposterise(interceptor,
                    targetClass);

        } catch (MockitoException e) {

            // delegate
            return fallbackProxyFactory.<T> createProxy(targetClass,
                    interceptor);
        }

        return proxy;
    }
}