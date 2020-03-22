/*
 * MIT License
 * 
 * Copyright (c) 2020 Breno Salles
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.brenosalles.authentication;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * This class is a singleton class responsible for authentication of drivers.
 * 
 * @author <a href="https://brenosalles.com" target="_blank">Breno</a>
 *
 * @since 1.0.0
 * @version 1.0.0
 * 
 */
public class Authentication {
    // Attributes
    private static Authentication instance;
    private ConcurrentHashMap<String, String> users = new ConcurrentHashMap<String, String>();

    // Constructor
    private Authentication() {
        /** Intentionally empty */
    }

    // Methods
    /**
     * This function is used to retrieve the singleton instance of this class.
     * 
     * @return {@link com.brenosalles.authentication.Authentication Authentication}
     *         contains the class instance.
     */
    public static Authentication getInstance() {
        if (instance == null) {
            synchronized (Authentication.class) {
                if (instance == null) {
                    instance = new Authentication();
                }
            }
        }
        return instance;
    }

    /**
     * This function is used to authenticate a driver.
     * 
     * @param username Contains driver username.
     * @param password Contains driver password.
     * @return true if signin was valid, false otherwise.
     */
    public Boolean signIn(String username, String password) {
        if (users.containsKey(username) == false) {
            return false;
        }

        return users.get(username).equals(password);
    }

    /**
     * 
     * @param username Contains new driver username.
     * @param password Contains new driver password.
     * @return true if signup was valid, false otherwise.
     */
    public Boolean signUp(String username, String password) {
        if (users.containsKey(username) == true) {
            return false;
        }

        users.put(username, password);

        return true;
    }

    /**
     * This method is used to clear the registered drivers.
     */
    public void resetUsers() {
        users.clear();
    }
}