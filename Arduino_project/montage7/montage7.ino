

int buttons[6]={2};
//int buttons[0] = 2;
int SOL=2;
int notes[]={262,294,330,349,394};//,440};

const int Pin=A0;
void setup(){
  //initialisation du crystaux liquide
  Serial.begin(9600);
 
  /*pinMode(ledPin,OUTPUT);
  digitalWrite(ledPin,HIGH);on en voie du courant*/
  }

void loop(){

  int keyVal=analogRead(Pin);
  noTone(8);
  int valueSol= digitalRead(SOL);
  Serial.print(keyVal);
  //delay(500);
  //delay(1000);
  if(keyVal==1023){
    tone(8,notes[0]);
    }
  else if(keyVal>=990 && keyVal <= 1010){
    tone(8,notes[1]);
    }
  else if(keyVal>=505 && keyVal <= 515){
    tone(8,notes[2]);
    }
  else if(keyVal>=5 && keyVal <= 10){
    tone(8,notes[3]);
    }
   else if(valueSol){
    tone(8,notes[4]);
    }
    else{
      noTone(8);
      }
  }

