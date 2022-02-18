a=true
times=0
while $a;do
  java lab01.WSGenerator -i ../words1.txt -o $(printf 'somefile%03d.txt' $times) -s 11
  java lab01.WSSolver -i $(printf 'somefile%03d.txt' $times) -o $(printf 'somefile%03dsolution.txt' $times) > /dev/null
  lines=$(cat $(printf 'somefile%03dsolution.txt' $times) | grep "^[A-Z].*[0-9].*" | wc -l)
  if [[ ! $lines -eq 7 ]];then
    echo "error"
    a=false
  fi
  times=$(( $times + 1 ))
  echo $times
done;
