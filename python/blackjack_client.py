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
        self.channel = grpc.insecure_channel(f'{self.host}:{self.server_port}')

        # bind the client to the server channel
        self.stub = blackjack_pb2_grpc.BlackjackServiceStub(self.channel)

        self.board_state = None

    def get_digest(self, message):
        """
        Client function to call the rpc for GetDigest
        """
        to_digest_message = blackjack_pb2.DigestMessage(ToDigest=message)
        return self.stub.GetDigestor(to_digest_message)

    def make_decision(self, board_state):
        # decision made based on strategy being implemented by client
        return 0 # always HIT

    def play_turn(self):
        # make decision
        decision = self.make_decision(self.board_state)
        
        # send decision to server and get new board state
        self.board_state = self.stub.makeADecision(decision)

if __name__ == '__main__':
    print ('This program is being run by itself')
    curr_client = BlackjackClient()
    board_state = curr_client.makeADecision('Random12312312ascsadvsascdaasdcsadcsds')
    print(digest)