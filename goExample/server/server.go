package main

import (
    "net/http"
    "fmt"
    "time"
)

var (
    qps = 0
    now = time.Now()
)

func main() {
    http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
        qps++
        cur := time.Now()
        if cur.Sub(now) >= 1e9 {
            fmt.Println(qps)
            qps = 0
            now = time.Now()
        }
    })
    http.ListenAndServe(":8887", nil)
}
