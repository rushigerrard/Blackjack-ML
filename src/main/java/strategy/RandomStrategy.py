from strategy import MLStrategy
from model import Decision

import random

class RandomStrategy(MLStrategy):
    def __init__(self):
        pass

    def makeADecision(self, state):
        return random.choice([Decision.HIT, Decision.STAND])