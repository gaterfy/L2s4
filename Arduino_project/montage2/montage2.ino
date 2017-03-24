/*
 * fin du projet 2
 * réalisé par berfy kunsangabo
 */
#define MAX 6
int clignote(); /*prototype */
int led[MAX]={4,5,6};
const int bouTon=2;
int lireB=0;
int cpt=0;
void setup(){
  /*initialisation*/
  for(cpt=0;cpt<MAX;cpt++){
    pinMode(led[cpt],OUTPUT);
  }
  pinMode(bouTon,INPUT);
  }

void loop(){
  lireB=digitalRead(bouTon);
  for(cpt=0;cpt<MAX;cpt++){
    digitalWrite(led[cpt],LOW);
  }
  if(lireB){
    clignote();
    }
  }
int clignote(){
  for(cpt=0;cpt<MAX;cpt++){
    digitalWrite(led[cpt],HIGH);
    delay(1000);/*delay en milliseconde */
  }
  return 0;
  }
