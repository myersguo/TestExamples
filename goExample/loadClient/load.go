package main

import (
    "fmt"
    "time"
    "os"
    "os/signal"
    . "runtime"
    "net/http"
    "sync"
)

const (
)

var (
)

func max(a, b time.Time) time.Time {
    if a.After(b) {
        return a
    }
    return b
}

func attack(ticks <- chan time.Time, workers *sync.WaitGroup) {
    defer workers.Done()
    for t:= range ticks {
        _, err := http.Get("http://localhost:8887/")
        if err != nil {
            fmt.Printf("%v\n", err)
        }
        fmt.Println(t, " attck")
    }
}

func main() {
    var workers sync.WaitGroup
    ticks := make(chan time.Time)
    defer close(ticks)
    sig := make(chan os.Signal, 1)
    signal.Notify(sig, os.Interrupt)
    
    rate := uint64(1500)
 
    hits := uint64(50000) 
    interval :=  1e9/uint64(rate)
    began, done := time.Now(), uint64(0)
    


    for {
        fmt.Printf("now routines %d\n", NumGoroutine())
        now, next := time.Now(), began.Add(time.Duration(done*interval))
        diff := next.Sub(now)
        time.Sleep(diff)
        fmt.Printf("now:%v, next:%v, diff:%v,done:%v\n", now, next, diff, done) 
        select {
            case ticks <- max(next, now):
                fmt.Printf("%v done %d\n", now,  done)
                if done++; done >= hits {
                    return
                }
            case <- sig:
                fmt.Println("stop")
                return
            default:
                fmt.Println("go attach")
                workers.Add(1)
                go attack(ticks, &workers)
        }
    }
    
}
