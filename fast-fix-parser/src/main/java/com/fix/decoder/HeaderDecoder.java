package com.fix.decoder;

import com.fix.constant.Constants;
import com.fix.exception.InvalidTagException;

import static com.fix.constant.Constants.*;
import static com.fix.util.bytes.BytesScanner.*;

public class HeaderDecoder implements Decoder {

    /* BeginString = 8 */
    private boolean hasBeginString;
    private char[] beginString = new char[1];
    private int beginStringLength = -1;

    public char[] beginString() {
        return beginString;
    }

    public boolean hasBeginString() {
        return hasBeginString;
    }

    public int beginStringLength() {
        return beginStringLength;
    }

    public String beginStringAsString() {
        return new String(beginString, 0, beginStringLength);
    }

    public void resetBeginString() {
        hasBeginString = false;
        beginStringLength = -1;
        for (int i = 0; i < beginString.length; i++) {
            beginString[i] = 0;
        }
    }

    /* BodyLength = 9 */
    private boolean hasBodyLength;
    private int bodyLength = -1;

    public int bodyLength() {
        return bodyLength;
    }

    public boolean hasBodyLength() {
        return hasBodyLength;
    }

    public void resetBodyLength() {
        hasBodyLength = false;
        bodyLength = -1;
    }


    /* MsgType = 35 */
    private boolean hasMsgType;
    private char[] msgType = new char[1];
    private int msgTypeLength = -1;

    public boolean hasMsgType() {
        return hasMsgType;
    }

    public char[] msgType() {
        return msgType;
    }

    public int msgTypeLength() {
        return msgTypeLength;
    }

    public String msgTypeAsString() {
        return new String(msgType, 0, msgTypeLength);
    }

    public void resetMsgType() {
        hasMsgType = false;
        msgTypeLength = -1;
        for (int i = 0; i < msgType.length; i++) {
            msgType[i] = 0;
        }
    }

    /* SenderCompID = 49 */
    private boolean hasSenderCompID;
    private char[] senderCompID = new char[1];
    private int senderCompIDLength = -1;

    public boolean hasSenderCompID() {
        return hasSenderCompID;
    }

    public char[] senderCompID() {
        return senderCompID;
    }

    public int senderCompIDLength() {
        return senderCompIDLength;
    }

    public String senderCompIDAsString() {
        return new String(senderCompID, 0, senderCompIDLength);
    }

    public void resetSenderCompID() {
        hasSenderCompID = false;
        senderCompIDLength = -1;
        for (int i = 0; i < senderCompID.length; i++) {
            senderCompID[i] = 0;
        }
    }

    /* TargetCompID = 56 */
    private boolean hasTargetCompID;
    private char[] targetCompID = new char[1];
    private int targetCompIDLength = -1;

    public boolean hasTargetCompID() {
        return hasTargetCompID;
    }

    public char[] targetCompID() {
        return targetCompID;
    }

    public int targetCompIDLength() {
        return targetCompIDLength;
    }

    public String targetCompIDAsString() {
        return new String(targetCompID, 0, targetCompIDLength);
    }

    public void resetTargetCompID() {
        hasTargetCompID = false;
        targetCompIDLength = -1;
        for (int i = 0; i < targetCompID.length; i++) {
            targetCompID[i] = 0;
        }
    }

    /* MsgSeqNum = 34 */
    private boolean hasMsgSeqNum;
    private int msgSeqNum = -1;

    public boolean hasMsgSeqNum() {
        return hasMsgSeqNum;
    }

    public int msgSeqNum() {
        return msgSeqNum;
    }

    public void resetMsgSeqNum() {
        hasMsgSeqNum = false;
        msgSeqNum = -1;
    }

    /* SendingTime = 52 */
    private boolean hasSendingTime;
    private char[] sendingTime = new char[27];
    private int sendingTimeLength;

    public boolean hasSendingTime() {
        return hasSendingTime;
    }

    public char[] sendingTime() {
        return sendingTime;
    }

    public int sendingTimeLength() {
        return sendingTimeLength;
    }

    public String sendingTimeAsString() {
        return new String(sendingTime, 0, sendingTimeLength);
    }

    public void resetSendingTime() {
        hasSendingTime = false;
        sendingTimeLength = -1;
        for (int i = 0; i < sendingTime.length; i++) {
            sendingTime[i] = 0;
        }
    }

    @Override
    public int decode(byte[] fixMessageBytes, int startOffset) {
        int end = fixMessageBytes.length;
        int tagPosition = startOffset;
        int tag;

        while (tagPosition < end) {
            final int equalsPosition = scan(fixMessageBytes, tagPosition, end, EQUAL_SIGN);
            tag = getInt(fixMessageBytes, tagPosition, equalsPosition);
            final int valueOffset = equalsPosition + 1;
            final int endOfField = scan(fixMessageBytes, valueOffset, end, START_OF_HEADER);
            final int valueLength = endOfField - valueOffset;

            switch (tag) {
                case Constants.BEGIN_STRING:
                    beginString = getChars(fixMessageBytes, beginString, valueOffset, valueLength);
                    beginStringLength = valueLength;
                    hasBeginString = true;
                    break;

                case Constants.BODY_LENGTH:
                    bodyLength = getInt(fixMessageBytes, valueOffset, endOfField);
                    hasBodyLength = true;
                    break;

                case Constants.MSG_TYPE:
                    msgType = getChars(fixMessageBytes, msgType, valueOffset, valueLength);
                    msgTypeLength = valueLength;
                    hasMsgType = true;
                    break;

                case Constants.SENDER_COMP_ID:
                    senderCompID = getChars(fixMessageBytes, senderCompID, valueOffset, valueLength);
                    senderCompIDLength = valueLength;
                    hasSenderCompID = true;
                    break;

                case Constants.TARGET_COMP_ID:
                    targetCompID = getChars(fixMessageBytes, targetCompID, valueOffset, valueLength);
                    targetCompIDLength = valueLength;
                    hasTargetCompID = true;
                    break;

                case Constants.MSG_SEQ_NUM:
                    msgSeqNum = getInt(fixMessageBytes, valueOffset, endOfField);
                    hasMsgSeqNum = true;
                    break;

                case Constants.SENDING_TIME:
                    sendingTime = getChars(fixMessageBytes, sendingTime, valueOffset, valueLength);
                    sendingTimeLength = valueLength;
                    hasSendingTime = true;
                    break;

                default:
                    // will return when the tagPosition hit the first tag of the body
                    // TODO: handle unknown tag
                    return tagPosition;

            }

            tagPosition = endOfField + 1;
        }
        return tagPosition;
    }

    @Override
    public void reset() {
        resetBeginString();
        resetBodyLength();
        resetMsgType();
        resetSenderCompID();
        resetTargetCompID();
        resetMsgSeqNum();
        resetSendingTime();
    }

    @Override
    public StringBuilder stringAppender() {
        StringBuilder sb = new StringBuilder();
        if (hasBeginString) {
            sb.append(BEGIN_STRING + "=").append(beginStringAsString()).append((char) START_OF_HEADER);
        }
        if (hasBodyLength) {
            sb.append(BODY_LENGTH + "=").append(bodyLength).append((char) START_OF_HEADER);
        }
        if (hasMsgType) {
            sb.append(MSG_TYPE + "=").append(msgTypeAsString()).append((char) START_OF_HEADER);
        }
        if (hasSenderCompID) {
            sb.append(SENDER_COMP_ID + "=").append(senderCompIDAsString()).append((char) START_OF_HEADER);
        }
        if (hasTargetCompID) {
            sb.append(TARGET_COMP_ID + "=").append(targetCompIDAsString()).append((char) START_OF_HEADER);
        }
        if (hasMsgSeqNum) {
            sb.append(MSG_SEQ_NUM + "=").append(msgSeqNum).append((char) START_OF_HEADER);
        }
        if (hasSendingTime) {
            sb.append(SENDING_TIME + "=").append(sendingTimeAsString()).append((char) START_OF_HEADER);
        }
        return sb;
    }
}
