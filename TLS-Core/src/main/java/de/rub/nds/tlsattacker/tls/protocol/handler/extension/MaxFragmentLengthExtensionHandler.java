/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.protocol.handler.extension;

import de.rub.nds.tlsattacker.tls.constants.ExtensionByteLength;
import de.rub.nds.tlsattacker.tls.constants.ExtensionType;
import de.rub.nds.tlsattacker.tls.constants.MaxFragmentLength;
import de.rub.nds.tlsattacker.tls.exceptions.AdjustmentException;
import de.rub.nds.tlsattacker.tls.protocol.message.extension.MaxFragmentLengthExtensionMessage;
import de.rub.nds.tlsattacker.tls.protocol.parser.ProtocolMessageParser;
import de.rub.nds.tlsattacker.tls.protocol.parser.extension.ExtensionParser;
import de.rub.nds.tlsattacker.tls.protocol.parser.extension.MaxFragmentLengthExtensionParser;
import de.rub.nds.tlsattacker.tls.protocol.preparator.ProtocolMessagePreparator;
import de.rub.nds.tlsattacker.tls.protocol.preparator.extension.ExtensionPreparator;
import de.rub.nds.tlsattacker.tls.protocol.preparator.extension.MaxFragmentLengthExtensionPreparator;
import de.rub.nds.tlsattacker.tls.protocol.serializer.ProtocolMessageSerializer;
import de.rub.nds.tlsattacker.tls.protocol.serializer.extension.ExtensionSerializer;
import de.rub.nds.tlsattacker.tls.protocol.serializer.extension.MaxFragmentLengthExtensionSerializer;
import de.rub.nds.tlsattacker.tls.workflow.TlsContext;
import de.rub.nds.tlsattacker.util.ArrayConverter;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Juraj Somorovsky <juraj.somorovsky@rub.de>
 */
public class MaxFragmentLengthExtensionHandler extends ExtensionHandler<MaxFragmentLengthExtensionMessage> {

    private static final Logger LOGGER = LogManager.getLogger("HANDLER");

    public MaxFragmentLengthExtensionHandler(TlsContext context) {
        super(context);
    }

    @Override
    protected void adjustTLSContext(MaxFragmentLengthExtensionMessage message) {
        byte[] maxFragmentLengthBytes = message.getMaxFragmentLength().getValue();
        if (maxFragmentLengthBytes.length != 1) {
            throw new AdjustmentException("Cannot adjust MaxFragmentLength to a resonable value");
        }
        MaxFragmentLength length = MaxFragmentLength.getMaxFragmentLength(maxFragmentLengthBytes[0]);
        if (length == null) {
            LOGGER.warn("Unknown MaxFragmentLength:" + ArrayConverter.bytesToHexString(maxFragmentLengthBytes));
        } else {
            context.setMaxFragmentLength(length);
        }
    }

    @Override
    public MaxFragmentLengthExtensionParser getParser(byte[] message, int pointer) {
        return new MaxFragmentLengthExtensionParser(pointer, message);
    }

    @Override
    public MaxFragmentLengthExtensionPreparator getPreparator(MaxFragmentLengthExtensionMessage message) {
        return new MaxFragmentLengthExtensionPreparator(context, message);
    }

    @Override
    public MaxFragmentLengthExtensionSerializer getSerializer(MaxFragmentLengthExtensionMessage message) {
        return new MaxFragmentLengthExtensionSerializer(message);
    }

}