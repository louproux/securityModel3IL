package cc.flavien.cryptolocker

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class EncryptMessageTest {
    @Test
    fun `should crypt and decrypt message`() {
        val cryptMessage: EncryptMessage = EncryptMessage()
        val stringValue = "my message"

        val encryptedMessage = cryptMessage.encrypt(stringValue.toByteArray())

        assertNotEquals(stringValue.toByteArray(), encryptedMessage)

        stringValue.toByteArray().zip(cryptMessage.decrypt(encryptedMessage)).forEach {
            assertEquals(it.first, it.second)
        }
    }
}