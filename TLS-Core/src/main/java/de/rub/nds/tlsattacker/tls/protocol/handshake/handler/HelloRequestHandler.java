/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.protocol.handshake.handler;

import de.rub.nds.tlsattacker.tls.constants.HandshakeByteLength;
import de.rub.nds.tlsattacker.tls.constants.HandshakeMessageType;
import de.rub.nds.tlsattacker.tls.exceptions.InvalidMessageTypeException;
import de.rub.nds.tlsattacker.tls.protocol.handshake.HelloRequestMessage;
import de.rub.nds.tlsattacker.tls.protocol.parser.Parser;
import de.rub.nds.tlsattacker.tls.protocol.preparator.Preparator;
import de.rub.nds.tlsattacker.tls.protocol.serializer.Serializer;
import de.rub.nds.tlsattacker.tls.workflow.TlsContext;
import de.rub.nds.tlsattacker.util.ArrayConverter;
import java.util.Arrays;

/**
 * @author Philip Riese <philip.riese@rub.de>
 */
public class HelloRequestHandler extends HandshakeMessageHandler<HelloRequestMessage> {

    public HelloRequestHandler(TlsContext tlsContext) {
        super(tlsContext);
    }

    //
    // @Override
    // public byte[] prepareMessageAction() {
    //
    // protocolMessage.setLength(0);
    //
    // long header = (HandshakeMessageType.HELLO_REQUEST.getValue() << 24) +
    // protocolMessage.getLength().getValue();
    //
    // protocolMessage.setCompleteResultingMessage(ArrayConverter.longToUint32Bytes(header));
    //
    // return protocolMessage.getCompleteResultingMessage().getValue();
    // }
    //
    // @Override
    // public int parseMessageAction(byte[] message, int pointer) {
    // if (message[pointer] != HandshakeMessageType.HELLO_REQUEST.getValue()) {
    // throw new
    // InvalidMessageTypeException("This is not a Hello Request message");
    // }
    // protocolMessage.setType(message[pointer]);
    //
    // int currentPointer = pointer + HandshakeByteLength.MESSAGE_TYPE;
    // int nextPointer = currentPointer +
    // HandshakeByteLength.MESSAGE_LENGTH_FIELD;
    // int length = ArrayConverter.bytesToInt(Arrays.copyOfRange(message,
    // currentPointer, nextPointer));
    // protocolMessage.setLength(length);
    // // should always be null
    //
    // currentPointer = nextPointer;
    //
    // protocolMessage.setCompleteResultingMessage(Arrays.copyOfRange(message,
    // pointer, nextPointer));
    //
    // return currentPointer;
    // }

    @Override
    protected Parser getParser(byte[] message, int pointer) {
        throw new UnsupportedOperationException("Not supported yet."); // To
                                                                       // change
                                                                       // body
                                                                       // of
                                                                       // generated
                                                                       // methods,
                                                                       // choose
                                                                       // Tools
                                                                       // |
                                                                       // Templates.
    }

    @Override
    protected Preparator getPreparator(HelloRequestMessage message) {
        throw new UnsupportedOperationException("Not supported yet."); // To
                                                                       // change
                                                                       // body
                                                                       // of
                                                                       // generated
                                                                       // methods,
                                                                       // choose
                                                                       // Tools
                                                                       // |
                                                                       // Templates.
    }

    @Override
    protected Serializer getSerializer(HelloRequestMessage message) {
        throw new UnsupportedOperationException("Not supported yet."); // To
                                                                       // change
                                                                       // body
                                                                       // of
                                                                       // generated
                                                                       // methods,
                                                                       // choose
                                                                       // Tools
                                                                       // |
                                                                       // Templates.
    }

    @Override
    protected void adjustTLSContext(HelloRequestMessage message) {
        throw new UnsupportedOperationException("Not supported yet."); // To
                                                                       // change
                                                                       // body
                                                                       // of
                                                                       // generated
                                                                       // methods,
                                                                       // choose
                                                                       // Tools
                                                                       // |
                                                                       // Templates.
    }
}
