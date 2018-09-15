package com.quaspec.web.util;

public interface QuatspecServiceConstants {
        public static interface SessionVariable{
             public static String CURRENTLOGIN="CURRENT_LOGIN_USER";
             public static String ACTIVEPROFILEMENU="ACTIVE_PROFILE_MENU";
             public static String ACTIVEPROFILE="ACTIVE_PROFILE";
             public static String SESSIONEVENT="SESSION_EVENT";
        }

        public static interface RequestVariable{
             public static String LANDINGREDIRECTION="LANDING_PAGE_URL";
             public static String LOGINLANDINGDIRECTION="LOGIN_PAGE_URL";
        }

        public static interface EVENTS{
             public static String LOGOUT="LOGOUT";
             public static String SESSIONEXPIRED="SESSIONEXPIRED";
        }

        public static interface RESPONSECODE{
            public static int  SUCCESS=200;
            public static int FAILED=201;
            public static int INTERSERVER_ERROR=500;
            public static int INCOMPLETE_REQUESTMESSAGE=202;
            public static int TARGETED_SERVICE_NOT_FOUND=400;
        }
}
