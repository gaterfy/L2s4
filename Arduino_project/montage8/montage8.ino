/**
 * montage 8 developpé par berfy kunsangabo
 */

//#define MAX 6
int switchState=0;
int prevSwitchState=0;

const int switchPin=8;
unsigned long previousTime=0;

//int led[MAX]={2,3,4,5,6,7};
int led=2;

int interval= 600;

void setup(){
  for(int x=2;x<8;x++){
    pinMode(x,OUTPUT);
    }
    pinMode(switchPin,INPUT);
  }

void loop(){
  unsigned long currentTime=millis();
  if(currentTime - previousTime > interval){
    previousTime = currentTime;
    digitalWrite(led,HIGH);
    led++;
    if (led==7){
      }
    }
    switchState= digitalRead(switchPin);
    if(switchState != prevSwitchState){
      for(int x=2;x<8;x++){
        pinMode(x,LOW);
        }
        led=2;
        previousTime=currentTime;
      }
      prevSwitchState=switchState;
  }
