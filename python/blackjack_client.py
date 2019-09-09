import grpc
# import the generated classes :
import blackjack_pb2
import blackjack_pb2_grpc

class BlackjackClient(object):
    """
    Client for accessing the gRPC functionality
    """
    def main():
        print("Hello")
		
    def __init__(self):
        # configure the host and the
        # the port to which the client should connect
        # to.
        self.host = 'localhost'
        self.server_port = 46001

        # instantiate a communication channel
        self.channel = grpc.insecure_channel(
                        '{}:{}'.format(self.host, self.server_port))

        # bind the client to the server channel
        self.stub = blackjack_pb2_grpc.BlackjackServiceStub(self.channel)

    def get_digest(self, message):
        """
        Client function to call the rpc for GetDigest
        """
        to_digest_message =blackjack_pb2.DigestMessage(ToDigest=message)
        return self.stub.GetDigestor(to_digest_message)

if __name__ == '__main__':
	print ('This program is being run by itself')
	curr_client = BlackjackClient()
	curr_client.get_digest('Random12312312ascsadvsascdaasdcsadcsds')