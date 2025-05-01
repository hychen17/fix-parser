package com.fix.constant;

public class Constants {

    public static String VERSION = "FIX.4.2";
    public static final byte START_OF_HEADER = (byte) 1;
    public static final byte EQUAL_SIGN = (byte) 61;


    public static char[] VERSION_CHARS = VERSION.toCharArray();

    public static final String HEARTBEAT_MESSAGE_AS_STR = "0";
    public static final long HEARTBEAT_MESSAGE = 48L;

    public static final String LOGON_MESSAGE_AS_STR = "A";
    public static final long LOGON_MESSAGE = 65L;

    public static final String TEST_REQUEST_MESSAGE_AS_STR = "1";
    public static final long TEST_REQUEST_MESSAGE = 49L;

    public static final String RESEND_REQUEST_MESSAGE_AS_STR = "2";
    public static final long RESEND_REQUEST_MESSAGE = 50L;

    public static final String REJECT_MESSAGE_AS_STR = "3";
    public static final long REJECT_MESSAGE = 51L;

    public static final String SEQUENCE_RESET_MESSAGE_AS_STR = "4";
    public static final long SEQUENCE_RESET_MESSAGE = 52L;

    public static final String LOGOUT_MESSAGE_AS_STR = "5";
    public static final long LOGOUT_MESSAGE = 53L;

    public static final String ADVERTISEMENT_MESSAGE_AS_STR = "7";
    public static final long ADVERTISEMENT_MESSAGE = 55L;

    public static final String INDICATION_OF_INTEREST_MESSAGE_AS_STR = "6";
    public static final long INDICATION_OF_INTEREST_MESSAGE = 54L;

    public static final String NEWS_MESSAGE_AS_STR = "B";
    public static final long NEWS_MESSAGE = 66L;

    public static final String EMAIL_MESSAGE_AS_STR = "C";
    public static final long EMAIL_MESSAGE = 67L;

    public static final String QUOTE_REQUEST_MESSAGE_AS_STR = "R";
    public static final long QUOTE_REQUEST_MESSAGE = 82L;

    public static final String QUOTE_MESSAGE_AS_STR = "S";
    public static final long QUOTE_MESSAGE = 83L;

    public static final String MASS_QUOTE_MESSAGE_AS_STR = "i";
    public static final long MASS_QUOTE_MESSAGE = 105L;

    public static final String QUOTE_CANCEL_MESSAGE_AS_STR = "Z";
    public static final long QUOTE_CANCEL_MESSAGE = 90L;

    public static final String QUOTE_STATUS_REQUEST_MESSAGE_AS_STR = "a";
    public static final long QUOTE_STATUS_REQUEST_MESSAGE = 97L;

    public static final String QUOTE_ACKNOWLEDGEMENT_MESSAGE_AS_STR = "b";
    public static final long QUOTE_ACKNOWLEDGEMENT_MESSAGE = 98L;

    public static final String MARKET_DATA_REQUEST_MESSAGE_AS_STR = "V";
    public static final long MARKET_DATA_REQUEST_MESSAGE = 86L;

    public static final String MARKET_DATA_SNAPSHOT_FULL_REFRESH_MESSAGE_AS_STR = "W";
    public static final long MARKET_DATA_SNAPSHOT_FULL_REFRESH_MESSAGE = 87L;

    public static final String MARKET_DATA_INCREMENTAL_REFRESH_MESSAGE_AS_STR = "X";
    public static final long MARKET_DATA_INCREMENTAL_REFRESH_MESSAGE = 88L;

    public static final String MARKET_DATA_REQUEST_REJECT_MESSAGE_AS_STR = "Y";
    public static final long MARKET_DATA_REQUEST_REJECT_MESSAGE = 89L;

    public static final String SECURITY_DEFINITION_REQUEST_MESSAGE_AS_STR = "c";
    public static final long SECURITY_DEFINITION_REQUEST_MESSAGE = 99L;

    public static final String SECURITY_DEFINITION_MESSAGE_AS_STR = "d";
    public static final long SECURITY_DEFINITION_MESSAGE = 100L;

    public static final String SECURITY_STATUS_REQUEST_MESSAGE_AS_STR = "e";
    public static final long SECURITY_STATUS_REQUEST_MESSAGE = 101L;

    public static final String SECURITY_STATUS_MESSAGE_AS_STR = "f";
    public static final long SECURITY_STATUS_MESSAGE = 102L;

    public static final String TRADING_SESSION_STATUS_REQUEST_MESSAGE_AS_STR = "g";
    public static final long TRADING_SESSION_STATUS_REQUEST_MESSAGE = 103L;

    public static final String TRADING_SESSION_STATUS_MESSAGE_AS_STR = "h";
    public static final long TRADING_SESSION_STATUS_MESSAGE = 104L;

    public static final String NEW_ORDER_SINGLE_MESSAGE_AS_STR = "D";
    public static final long NEW_ORDER_SINGLE_MESSAGE = 68L;

    public static final String EXECUTION_REPORT_MESSAGE_AS_STR = "8";
    public static final long EXECUTION_REPORT_MESSAGE = 56L;

    public static final String DONT_KNOW_TRADE_MESSAGE_AS_STR = "Q";
    public static final long DONT_KNOW_TRADE_MESSAGE = 81L;

    public static final String ORDER_CANCEL_REPLACE_REQUEST_MESSAGE_AS_STR = "G";
    public static final long ORDER_CANCEL_REPLACE_REQUEST_MESSAGE = 71L;

    public static final String ORDER_CANCEL_REQUEST_MESSAGE_AS_STR = "F";
    public static final long ORDER_CANCEL_REQUEST_MESSAGE = 70L;

    public static final String ORDER_CANCEL_REJECT_MESSAGE_AS_STR = "9";
    public static final long ORDER_CANCEL_REJECT_MESSAGE = 57L;

    public static final String ORDER_STATUS_REQUEST_MESSAGE_AS_STR = "H";
    public static final long ORDER_STATUS_REQUEST_MESSAGE = 72L;

    public static final String ALLOCATION_MESSAGE_AS_STR = "J";
    public static final long ALLOCATION_MESSAGE = 74L;

    public static final String ALLOCATION_A_C_K_MESSAGE_AS_STR = "P";
    public static final long ALLOCATION_A_C_K_MESSAGE = 80L;

    public static final String SETTLEMENT_INSTRUCTIONS_MESSAGE_AS_STR = "T";
    public static final long SETTLEMENT_INSTRUCTIONS_MESSAGE = 84L;

    public static final String BID_REQUEST_MESSAGE_AS_STR = "k";
    public static final long BID_REQUEST_MESSAGE = 107L;

    public static final String BID_RESPONSE_MESSAGE_AS_STR = "l";
    public static final long BID_RESPONSE_MESSAGE = 108L;

    public static final String NEW_ORDER_LIST_MESSAGE_AS_STR = "E";
    public static final long NEW_ORDER_LIST_MESSAGE = 69L;

    public static final String LIST_STRIKE_PRICE_MESSAGE_AS_STR = "m";
    public static final long LIST_STRIKE_PRICE_MESSAGE = 109L;

    public static final String LIST_STATUS_MESSAGE_AS_STR = "N";
    public static final long LIST_STATUS_MESSAGE = 78L;

    public static final String LIST_EXECUTE_MESSAGE_AS_STR = "L";
    public static final long LIST_EXECUTE_MESSAGE = 76L;

    public static final String LIST_CANCEL_REQUEST_MESSAGE_AS_STR = "K";
    public static final long LIST_CANCEL_REQUEST_MESSAGE = 75L;

    public static final String LIST_STATUS_REQUEST_MESSAGE_AS_STR = "M";
    public static final long LIST_STATUS_REQUEST_MESSAGE = 77L;

    public static final String BUSINESS_MESSAGE_REJECT_MESSAGE_AS_STR = "j";
    public static final long BUSINESS_MESSAGE_REJECT_MESSAGE = 106L;

    public static final String TITAN_QUERY_POS_REQUEST_MESSAGE_AS_STR = "URP";
    public static final long TITAN_QUERY_POS_REQUEST_MESSAGE = 5263957L;

    public static final String TITAN_QUERY_POS_RESPONSE_MESSAGE_AS_STR = "UPR";
    public static final long TITAN_QUERY_POS_RESPONSE_MESSAGE = 5394517L;

    public static final String TITAN_QUERY_EXEC_REQUEST_MESSAGE_AS_STR = "URT";
    public static final long TITAN_QUERY_EXEC_REQUEST_MESSAGE = 5526101L;

    public static final String TITAN_QUERY_EXEC_RESPONSE_MESSAGE_AS_STR = "UTR";
    public static final long TITAN_QUERY_EXEC_RESPONSE_MESSAGE = 5395541L;

    public static final String TITAN_QUERY_BALANCE_REQUEST_MESSAGE_AS_STR = "URB";
    public static final long TITAN_QUERY_BALANCE_REQUEST_MESSAGE = 4346453L;

    public static final String TITAN_QUERY_BALANCE_RESPONSE_MESSAGE_AS_STR = "UBR";
    public static final long TITAN_QUERY_BALANCE_RESPONSE_MESSAGE = 5390933L;

    public static final int NET_GROSS_IND = 430;

    public static final int LIST_STATUS_TEXT = 444;

    public static final int BEGIN_STRING = 8;

    public static final int ORIG_SENDING_TIME = 122;

    public static final int GF_I_WOULD_PX = 21001;

    public static final int BID_PX = 132;

    public static final int NOTIFY_BROKER_OF_CREDIT = 208;

    public static final int I_O_I_ID = 23;

    public static final int REF_SEQ_NUM = 45;

    public static final int M_D_ENTRY_BUYER = 288;

    public static final int SETTL_INST_SOURCE = 165;

    public static final int DEF_OFFER_SIZE = 294;

    public static final int LINES_OF_TEXT = 33;

    public static final int SECURITY_TRADING_STATUS = 326;

    public static final int NO_ROUTING_IDS_GROUP_COUNTER = 215;

    public static final int OPT_ATTRIBUTE = 206;

    public static final int RULE80_A = 47;

    public static final int TOTAL_VOLUME_TRADED = 387;

    public static final int PEG_DIFFERENCE = 211;

    public static final int CONTRA_TRADE_TIME = 438;

    public static final int ADV_REF_ID = 3;

    public static final int TOTAL_NUM_SECURITIES = 393;

    public static final int EXEC_BROKER = 76;

    public static final int SENDER_LOCATION_ID = 142;

    public static final int REF_ALLOC_ID = 72;

    public static final int TRAD_SES_MODE = 339;

    public static final int CORPORATE_ACTION = 292;

    public static final int LOW_PX = 333;

    public static final int DUE_TO_RELATED = 329;

    public static final int M_D_ENTRY_PX = 270;

    public static final int NUM_TICKETS = 395;

    public static final int M_D_ENTRY_DATE = 272;

    public static final int VALUE_OF_FUTURES = 408;

    public static final int BUY_VOLUME = 330;

    public static final int FOREX_REQ = 121;

    public static final int NO_I_O_I_QUALIFIERS = 199;

    public static final int TITAN_REQUEST_ID = 12002;

    public static final int DESK_ID = 284;

    public static final int LIQUIDITY_IND_TYPE = 409;

    public static final int FDS_CLOSING_PRINT = 7141;

    public static final int LAST_PX = 31;

    public static final int TRAD_SES_STATUS = 340;

    public static final int LIST_NAME = 392;

    public static final int FAIR_VALUE = 406;

    public static final int UNDERLYING_MATURITY_DAY = 314;

    public static final int LAST_MKT = 30;

    public static final int LOCATE_REQD = 114;

    public static final int MESSAGE_ENCODING = 347;

    public static final int NO_BID_DESCRIPTORS = 398;

    public static final int UNDERLYING_CONTRACT_MULTIPLIER = 436;

    public static final int ACCRUED_INTEREST_AMT = 159;

    public static final int TRAD_SES_METHOD = 338;

    public static final int GF_CLOSING_PRINT = 5616;

    public static final int NO_QUOTE_ENTRIES_GROUP_COUNTER = 295;

    public static final int NO_M_D_ENTRIES = 268;

    public static final int ALLOC_HANDL_INST = 209;

    public static final int UNDERLYING_ISSUER = 306;

    public static final int ALLOC_LINK_TYPE = 197;

    public static final int END_SEQ_NO = 16;

    public static final int SYMBOL_SFX = 65;

    public static final int EXPIRE_DATE = 432;

    public static final int SETTL_CURR_FX_RATE_CALC = 156;

    public static final int TARGET_COMP_ID = 56;

    public static final int TITAN_IS_LAST_RCD = 12001;

    public static final int XML_DATA_LEN = 212;

    public static final int FDS_ALGO_SUITE = 7110;

    public static final int SETTL_LOCATION = 166;

    public static final int ENCODED_TEXT_LEN = 354;

    public static final int LIST_EXEC_INST_TYPE = 433;

    public static final int ORDER_QTY2 = 192;

    public static final int DEF_BID_SIZE = 293;

    public static final int NO_RELATED_SYM_GROUP_COUNTER = 146;

    public static final int M_D_ENTRY_SIZE = 271;

    public static final int HEADLINE = 148;

    public static final int SETTL_INST_ID = 162;

    public static final int ENCODED_HEADLINE_LEN = 358;

    public static final int NO_QUOTE_SETS = 296;

    public static final int SENDER_SUB_ID = 50;

    public static final int CASH_ORDER_QTY = 152;

    public static final int SIDE_VALUE_IND = 401;

    public static final int LINES_OF_TEXT_GROUP_COUNTER = 33;

    public static final int NO_MSG_TYPES = 384;

    public static final int BASIS_PX_TYPE = 419;

    public static final int NO_BID_COMPONENTS = 420;

    public static final int WAVE_NO = 105;

    public static final int M_D_ENTRY_POSITION_NO = 290;

    public static final int COVERED_OR_UNCOVERED = 203;

    public static final int PRICE_TYPE = 423;

    public static final int TRAD_SES_REQ_ID = 335;

    public static final int UNDERLYING_MATURITY_MONTH_YEAR = 313;

    public static final int GF_DISPLAY_QTY_VARIANCE = 6091;

    public static final int EFFECTIVE_TIME = 168;

    public static final int NO_STRIKES_GROUP_COUNTER = 428;

    public static final int TRAD_SES_OPEN_TIME = 342;

    public static final int TRANSACT_TIME = 60;

    public static final int BBG_URGENCY = 7504;

    public static final int NO_ROUTING_IDS = 215;

    public static final int NO_ORDERS_GROUP_COUNTER = 73;

    public static final int TITAN_MAX_PCT_VOLUME = 11007;

    public static final int TITAN_TDY_POS_QTY = 12006;

    public static final int CROSS_PERCENT = 413;

    public static final int ALLOC_PRICE = 366;

    public static final int SECURITY_ID = 48;

    public static final int CASH_SETTL_AGENT_CONTACT_NAME = 186;

    public static final int FDS_I_WOULD_QTY = 7138;

    public static final int OFFER_FORWARD_POINTS = 191;

    public static final int SETTLMNT_TYP = 63;

    public static final int NO_M_D_ENTRIES_GROUP_COUNTER = 268;

    public static final int SETTL_CURR_AMT = 119;

    public static final int RPT_SEQ = 83;

    public static final int NO_RELATED_SYM = 146;

    public static final int BBG_STRATEGY_ID = 7505;

    public static final int BUSINESS_REJECT_REASON = 380;

    public static final int SECONDARY_ORDER_ID = 198;

    public static final int NO_MISC_FEES_GROUP_COUNTER = 136;

    public static final int TITAN_AMOUNT = 12010;

    public static final int NO_BID_DESCRIPTORS_GROUP_COUNTER = 398;

    public static final int NO_TRADING_SESSIONS = 386;

    public static final int TEST_REQ_ID = 112;

    public static final int LAST_MSG_SEQ_NUM_PROCESSED = 369;

    public static final int REPORT_TO_EXCH = 113;

    public static final int NUM_DAYS_INTEREST = 157;

    public static final int SENDER_COMP_ID = 49;

    public static final int ON_BEHALF_OF_SENDING_TIME = 370;

    public static final int EMAIL_TYPE = 94;

    public static final int TITAN_START_TIME = 11005;

    public static final int EXEC_ID = 17;

    public static final int ENCODED_TEXT = 355;

    public static final int I_O_I_SHARES = 27;

    public static final int LOCATION_ID = 283;

    public static final int SECURITY_SETTL_AGENT_ACCT_NUM = 178;

    public static final int PROG_RPT_REQS = 414;

    public static final int EMAIL_THREAD_ID = 164;

    public static final int SECURITY_SETTL_AGENT_CONTACT_PHONE = 181;

    public static final int UNDERLYING_PUT_OR_CALL = 315;

    public static final int TRADING_SESSION_ID = 336;

    public static final int SETTL_CURRENCY = 120;

    public static final int UNDERLYING_SECURITY_DESC = 307;

    public static final int BID_DESCRIPTOR = 400;

    public static final int ENCODED_SECURITY_DESC = 351;

    public static final int SETTL_INST_REF_ID = 214;

    public static final int M_D_MKT = 275;

    public static final int SETTL_INST_MODE = 160;

    public static final int GF_PVT_UP_PCT = 21004;

    public static final int ADJUSTMENT = 334;

    public static final int ENCODED_SUBJECT = 357;

    public static final int GF_START_TIME = 6062;

    public static final int MARKET_DEPTH = 264;

    public static final int FDS_BCAN = 8018;

    public static final int EXEC_TRANS_TYPE = 20;

    public static final int CXL_REJ_RESPONSE_TO = 434;

    public static final int SELLER_DAYS = 287;

    public static final int ENCODED_UNDERLYING_ISSUER_LEN = 362;

    public static final int MAX_MESSAGE_SIZE = 383;

    public static final int UNDERLYING_SYMBOL = 311;

    public static final int GF_DISPLAY_QTY = 6066;

    public static final int GF_DISPLAY_QTY_UNIT = 6090;

    public static final int EXCHANGE_FOR_PHYSICAL = 411;

    public static final int LIST_EXEC_INST = 69;

    public static final int ID_SOURCE = 22;

    public static final int D_K_REASON = 127;

    public static final int I_O_I_REF_ID = 26;

    public static final int FINANCIAL_STATUS = 291;

    public static final int FDS_GET_DONE = 7131;

    public static final int SIDE = 54;

    public static final int SECURITY_STATUS_REQ_ID = 324;

    public static final int SENDING_TIME = 52;

    public static final int SECURE_DATA_LEN = 90;

    public static final int U_R_L_LINK = 149;

    public static final int DAY_CUM_QTY = 425;

    public static final int COUPON_RATE = 223;

    public static final int FDS_PVT_UP_PCT = 7148;

    public static final int ALLOC_TEXT = 161;

    public static final int QUOTE_REJECT_REASON = 300;

    public static final int QUOTE_SET_VALID_UNTIL_TIME = 367;

    public static final int TEXT = 58;

    public static final int MSG_TYPE = 35;

    public static final int CXL_REJ_REASON = 102;

    public static final int BID_ID = 390;

    public static final int LIQUIDITY_NUM_SECURITIES = 441;

    public static final int ALLOC_AVG_PX = 153;

    public static final int I_O_I_QLTY_IND = 25;

    public static final int NO_ALLOCS_GROUP_COUNTER = 78;

    public static final int TOT_NO_STRIKES = 422;

    public static final int MATURITY_MONTH_YEAR = 200;

    public static final int CASH_SETTL_AGENT_ACCT_NUM = 184;

    public static final int NO_MSG_TYPES_GROUP_COUNTER = 384;

    public static final int BID_TYPE = 394;

    public static final int FDS_PVT_DOWN_PX = 7149;

    public static final int DISCRETION_INST = 388;

    public static final int SETTL_INST_CODE = 175;

    public static final int HALT_REASON = 327;

    public static final int STAND_INST_DB_ID = 171;

    public static final int ENCODED_UNDERLYING_SECURITY_DESC = 365;

    public static final int CXL_QTY = 84;

    public static final int UNDERLYING_ID_SOURCE = 305;

    public static final int INC_TAX_IND = 416;

    public static final int NEW_SEQ_NO = 36;

    public static final int M_D_ENTRY_TIME = 273;

    public static final int SUBSCRIPTION_REQUEST_TYPE = 263;

    public static final int CL_ORD_ID = 11;

    public static final int UNDERLYING_SECURITY_TYPE = 310;

    public static final int LIST_SEQ_NO = 67;

    public static final int OPEN_CLOSE_SETTLE_FLAG = 286;

    public static final int ENCODED_ISSUER_LEN = 348;

    public static final int SECURITY_RESPONSE_ID = 322;

    public static final int PRICE = 44;

    public static final int ENCODED_ALLOC_TEXT = 361;

    public static final int TRAD_SES_PRE_CLOSE_TIME = 343;

    public static final int FUT_SETT_DATE2 = 193;

    public static final int WT_AVERAGE_LIQUIDITY = 410;

    public static final int EXPIRE_TIME = 126;

    public static final int ORDER_QTY = 38;

    public static final int ISSUER = 106;

    public static final int SYMBOL = 55;

    public static final int TOT_NO_ORDERS = 68;

    public static final int SECURITY_REQUEST_TYPE = 321;

    public static final int LIQUIDITY_VALUE = 404;

    public static final int LIQUIDITY_PCT_HIGH = 403;

    public static final int QUOTE_CONDITION = 276;

    public static final int GF_FUNDING_TYPE = 22000;

    public static final int QUOTE_ENTRY_ID = 299;

    public static final int CLEARING_ACCOUNT = 440;

    public static final int M_D_ENTRY_TYPE = 269;

    public static final int CASH_SETTL_AGENT_NAME = 182;

    public static final int NO_QUOTE_ENTRIES = 295;

    public static final int GF_MAX_PCT_VOLUME = 6064;

    public static final int NO_RPTS = 82;

    public static final int RAW_DATA_LENGTH = 95;

    public static final int QUOTE_CANCEL_TYPE = 298;

    public static final int IN_VIEW_OF_COMMON = 328;

    public static final int UNDERLYING_SYMBOL_SFX = 312;

    public static final int FDS_PVT_UP_PX = 7147;

    public static final int CONTRA_BROKER = 375;

    public static final int STOP_PX = 99;

    public static final int LIST_ID = 66;

    public static final int GAP_FILL_FLAG = 123;

    public static final int ROUTING_ID = 217;

    public static final int HEART_BT_INT = 108;

    public static final int GROSS_TRADE_AMT = 381;

    public static final int DELETE_REASON = 285;

    public static final int MISC_FEE_AMT = 137;

    public static final int NUM_BIDDERS = 417;

    public static final int I_O_I_TRANS_TYPE = 28;

    public static final int QUOTE_ENTRY_REJECT_REASON = 368;

    public static final int TITAN_CLOSE_FROZEN_POS_QTY = 12008;

    public static final int ALLOC_ID = 70;

    public static final int CURRENCY = 15;

    public static final int NO_DLVY_INST = 85;

    public static final int TITAN_HEDGE_FLAG = 12004;

    public static final int EXEC_TYPE = 150;

    public static final int OUTSIDE_INDEX_PCT = 407;

    public static final int RAW_DATA = 96;

    public static final int BID_DESCRIPTOR_TYPE = 399;

    public static final int TITAN_STRATEGY_ID = 11000;

    public static final int SECURITY_SETTL_AGENT_NAME = 176;

    public static final int BID_FORWARD_POINTS = 189;

    public static final int CASH_SETTL_AGENT_CONTACT_PHONE = 187;

    public static final int UNDERLYING_SECURITY_EXCHANGE = 308;

    public static final int LIST_STATUS_TYPE = 429;

    public static final int ON_BEHALF_OF_SUB_ID = 116;

    public static final int ENCODED_ALLOC_TEXT_LEN = 360;

    public static final int I_O_I_QUALIFIER = 104;

    public static final int RESET_SEQ_NUM_FLAG = 141;

    public static final int STAND_INST_DB_NAME = 170;

    public static final int SECURITY_SETTL_AGENT_CONTACT_NAME = 180;

    public static final int POSS_RESEND = 97;

    public static final int FDS_OPENING_PRINT = 7139;

    public static final int MIN_QTY = 110;

    public static final int ENCODED_LIST_EXEC_INST = 353;

    public static final int LIST_ORDER_STATUS = 431;

    public static final int BID_SIZE = 134;

    public static final int SECURITY_REQ_ID = 320;

    public static final int TICK_DIRECTION = 274;

    public static final int REF_TAG_ID = 371;

    public static final int AGGREGATED_BOOK = 266;

    public static final int GF_END_TIME = 6063;

    public static final int GF_PVT_DOWN_PX = 21005;

    public static final int TITAN_URGENCY = 11008;

    public static final int NO_ALLOCS = 78;

    public static final int CUM_QTY = 14;

    public static final int PUT_OR_CALL = 201;

    public static final int VALID_UNTIL_TIME = 62;

    public static final int QUOTE_REQUEST_TYPE = 303;

    public static final int STRIKE_TIME = 443;

    public static final int TITAN_FREEZE_AMT = 12011;

    public static final int ENCODED_HEADLINE = 359;

    public static final int SETTL_BRKR_CODE = 174;

    public static final int CASH_SETTL_AGENT_CODE = 183;

    public static final int DAY_ORDER_QTY = 424;

    public static final int BID_SPOT_RATE = 188;

    public static final int COMMISSION = 12;

    public static final int NO_TRADING_SESSIONS_GROUP_COUNTER = 386;

    public static final int DISCRETION_OFFSET = 389;

    public static final int NO_CONTRA_BROKERS_GROUP_COUNTER = 382;

    public static final int M_D_ENTRY_REF_ID = 280;

    public static final int ACCRUED_INTEREST_RATE = 158;

    public static final int QUOTE_SET_ID = 302;

    public static final int TITAN_REMARKS2 = 5476;

    public static final int MISC_FEE_CURR = 138;

    public static final int M_D_ENTRY_ORIGINATOR = 282;

    public static final int TIME_IN_FORCE = 59;

    public static final int NET_MONEY = 118;

    public static final int ENCODED_LIST_STATUS_TEXT_LEN = 445;

    public static final int HANDL_INST = 21;

    public static final int ON_BEHALF_OF_LOCATION_ID = 144;

    public static final int ENCRYPT_METHOD = 98;

    public static final int LAST_CAPACITY = 29;

    public static final int QUOTE_ID = 117;

    public static final int ORD_TYPE = 40;

    public static final int TARGET_SUB_ID = 57;

    public static final int TITAN_OPEN_FROZEN_POS_QTY = 12007;

    public static final int UNDERLYING_CURRENCY = 318;

    public static final int UNSOLICITED_INDICATOR = 325;

    public static final int ALLOC_STATUS = 87;

    public static final int NUMBER_OF_ORDERS = 346;

    public static final int QUOTE_RESPONSE_LEVEL = 301;

    public static final int ENCODED_SECURITY_DESC_LEN = 350;

    public static final int NO_MISC_FEES = 136;

    public static final int CONTRA_TRADE_QTY = 437;

    public static final int M_D_UPDATE_TYPE = 265;

    public static final int TITAN_END_TIME = 11006;

    public static final int ALLOC_SHARES = 80;

    public static final int EXEC_REF_ID = 19;

    public static final int TARGET_LOCATION_ID = 143;

    public static final int ENCODED_ISSUER = 349;

    public static final int FDS_PVT_DOWN_PCT = 7150;

    public static final int BUSINESS_REJECT_REF_ID = 379;

    public static final int TRADE_TYPE = 418;

    public static final int ADV_ID = 2;

    public static final int ORIG_TIME = 42;

    public static final int GF_URGENCY = 6065;

    public static final int SELL_VOLUME = 331;

    public static final int RELATD_SYM = 46;

    public static final int NO_M_D_ENTRY_TYPES = 267;

    public static final int PROG_PERIOD_INTERVAL = 415;

    public static final int SECURITY_EXCHANGE = 207;

    public static final int CLIENT_BID_ID = 391;

    public static final int GF_FUNDING_SRC = 22001;

    public static final int LEAVES_QTY = 151;

    public static final int GF_PVT_UP_PX = 21003;

    public static final int ORD_REJ_REASON = 103;

    public static final int STRIKE_PRICE = 202;

    public static final int AVG_PRX_PRECISION = 74;

    public static final int GF_LAYERING = 21007;

    public static final int DELIVER_TO_SUB_ID = 129;

    public static final int TRAD_SES_START_TIME = 341;

    public static final int SUBJECT = 147;

    public static final int FDS_I_WOULD_PX = 7125;

    public static final int FDS_STRATEGY_ID = 7111;

    public static final int TITAN_IS_SUCCEED = 12003;

    public static final int ACCOUNT = 1;

    public static final int TOT_QUOTE_ENTRIES = 304;

    public static final int POSS_DUP_FLAG = 43;

    public static final int SETTL_CURR_FX_RATE = 155;

    public static final int ENCODED_UNDERLYING_ISSUER = 363;

    public static final int OFFER_SIZE = 135;

    public static final int REQUEST_ID = 8088;

    public static final int ALLOC_ACCOUNT = 79;

    public static final int SETTL_INST_TRANS_TYPE = 163;

    public static final int I_O_I_OTH_SVC = 24;

    public static final int UNDERLYING_COUPON_RATE = 435;

    public static final int M_D_UPDATE_ACTION = 279;

    public static final int ON_BEHALF_OF_COMP_ID = 115;

    public static final int GF_PVT_DOWN_PCT = 21006;

    public static final int DAY_AVG_PX = 426;

    public static final int NO_QUOTE_SETS_GROUP_COUNTER = 296;

    public static final int FDS_START_TIME = 7113;

    public static final int BEGIN_SEQ_NO = 7;

    public static final int EXEC_INST = 18;

    public static final int SHARES = 53;

    public static final int SOLICITED_FLAG = 377;

    public static final int M_D_REQ_ID = 262;

    public static final int TITAN_AVAILABLE_AMT = 12009;

    public static final int SECURITY_SETTL_AGENT_ACCT_NAME = 179;

    public static final int M_D_REQ_REJ_REASON = 281;

    public static final int SECURITY_RESPONSE_TYPE = 323;

    public static final int ENCODED_LIST_STATUS_TEXT = 446;

    public static final int TITAN_PLAN_CODE = 11001;

    public static final int OFFER_SPOT_RATE = 190;

    public static final int GF_BCAN = 21008;

    public static final int NO_EXECS_GROUP_COUNTER = 124;

    public static final int ALLOC_TRANS_TYPE = 71;

    public static final int FDS_LAYERING = 7151;

    public static final int TRAD_SES_CLOSE_TIME = 344;

    public static final int ALLOC_REJ_CODE = 88;

    public static final int M_D_ENTRY_SELLER = 289;

    public static final int ADV_SIDE = 4;

    public static final int NO_EXECS = 124;

    public static final int CHECK_SUM = 10;

    public static final int G_T_BOOKING_INST = 427;

    public static final int COUNTRY = 421;

    public static final int ORIG_CL_ORD_ID = 41;

    public static final int BID_REQUEST_TRANS_TYPE = 374;

    public static final int SECURITY_TYPE = 167;

    public static final int GF_STRATEGY_ID = 6061;

    public static final int STAND_INST_DB_TYPE = 169;

    public static final int ALLOC_LINK_ID = 196;

    public static final int DLVY_INST = 86;

    public static final int QUOTE_ACK_STATUS = 297;

    public static final int NO_M_D_ENTRY_TYPES_GROUP_COUNTER = 267;

    public static final int BROKER_OF_CREDIT = 92;

    public static final int LOCATE_IDENTIFIER = 5701;

    public static final int SETTL_DEPOSITORY_CODE = 173;

    public static final int TRADE_DATE = 75;

    public static final int FDS_MAX_PCT_PPT_VOL = 7126;

    public static final int ROUTING_TYPE = 216;

    public static final int ENCODED_SUBJECT_LEN = 356;

    public static final int SPREAD_TO_BENCHMARK = 218;

    public static final int CLEARING_FIRM = 439;

    public static final int DELIVER_TO_LOCATION_ID = 145;

    public static final int CONTRA_TRADER = 337;

    public static final int ENCODED_LIST_EXEC_INST_LEN = 352;

    public static final int NO_STRIKES = 428;

    public static final int COMM_TYPE = 13;

    public static final int E_F_P_TRACKING_ERROR = 405;

    public static final int EXEC_RESTATEMENT_REASON = 378;

    public static final int AYER_BCAN = 5407;

    public static final int SIGNATURE_LENGTH = 93;

    public static final int BBG_MAX_PCT_VOLUME = 7560;

    public static final int LAST_SHARES = 32;

    public static final int GF_OPENING_PRINT = 5615;

    public static final int CONTRACT_MULTIPLIER = 231;

    public static final int XML_DATA = 213;

    public static final int MULTI_LEG_REPORTING_TYPE = 442;

    public static final int UNDERLYING_STRIKE_PRICE = 316;

    public static final int LAST_FORWARD_POINTS = 195;

    public static final int NO_I_O_I_QUALIFIERS_GROUP_COUNTER = 199;

    public static final int RATIO_QTY = 319;

    public static final int OFFER_PX = 133;

    public static final int NO_BID_COMPONENTS_GROUP_COUNTER = 420;

    public static final int FDS_DISPLAY_QTY = 7163;

    public static final int ORDER_ID = 37;

    public static final int ALLOC_NET_MONEY = 154;

    public static final int SECURITY_SETTL_AGENT_CODE = 177;

    public static final int AVG_PX = 6;

    public static final int LIQUIDITY_PCT_LOW = 402;

    public static final int ORD_STATUS = 39;

    public static final int NO_ORDERS = 73;

    public static final int FDS_MAX_PCT_VOLUME = 7137;

    public static final int PREV_CLOSE_PX = 140;

    public static final int BENCHMARK = 219;

    public static final int COMPLIANCE_ID = 376;

    public static final int BODY_LENGTH = 9;

    public static final int CASH_SETTL_AGENT_ACCT_NAME = 185;

    public static final int OPEN_CLOSE = 77;

    public static final int PROCESS_CODE = 81;

    public static final int MSG_SEQ_NUM = 34;

    public static final int I_O_I_NATURAL_FLAG = 130;

    public static final int SECURE_DATA = 91;

    public static final int CUSTOMER_OR_FIRM = 204;

    public static final int M_D_ENTRY_ID = 278;

    public static final int QUOTE_REQ_ID = 131;

    public static final int CLIENT_ID = 109;

    public static final int HIGH_PX = 332;

    public static final int GF_I_WOULD_QTY = 21002;

    public static final int UNDERLYING_SECURITY_ID = 309;

    public static final int UNDERLYING_OPT_ATTRIBUTE = 317;

    public static final int SIDE_VALUE1 = 396;

    public static final int FUT_SETT_DATE = 64;

    public static final int OUT_MAIN_CNTRY_U_INDEX = 412;

    public static final int LAST_SPOT_RATE = 194;

    public static final int DELIVER_TO_COMP_ID = 128;

    public static final int SIDE_VALUE2 = 397;

    public static final int ENCODED_UNDERLYING_SECURITY_DESC_LEN = 364;

    public static final int MSG_DIRECTION = 385;

    public static final int LOCATE_BROKER = 5700;

    public static final int ADV_TRANS_TYPE = 5;

    public static final int SECURITY_DESC = 107;

    public static final int MAX_FLOOR = 111;

    public static final int TITAN_DRAWABLE = 12012;

    public static final int REF_MSG_TYPE = 372;

    public static final int NO_CONTRA_BROKERS = 382;

    public static final int MAX_SHOW = 210;

    public static final int SETTL_DELIVERY_TYPE = 172;

    public static final int SESSION_REJECT_REASON = 373;

    public static final int TRADE_CONDITION = 277;

    public static final int TRAD_SES_END_TIME = 345;

    public static final int TITAN_YTD_POS_QTY = 12005;

    public static final int MISC_FEE_TYPE = 139;

    public static final int SIGNATURE = 89;

    public static final int FDS_URGENCY = 7128;

    public static final int URGENCY = 61;

    public static final int MATURITY_DAY = 205;

    public static final int EX_DESTINATION = 100;

}

